package Metaphase02;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 自定义HashMap，hash算法直接使用HashMap中的hash算法，解决哈希冲突
 * 采用链地址法，即链表+数组实现，包括方法有put(K key, V value), get(K key),
 * remove(K key)等方法
 * <p>
 * hashCode方法是将引用类型的内存地址转换为一个32位的整型返回，所以存在一定的
 * 限制，导致两个不同对象有可能hashCode也会相等，这样的话比较了hash值还需要比较
 * 引用，才能够保证两个对象完全相等。
 * <p>
 * 哈希表扩容
 * <p>
 * HashMap迭代器实现
 * <p>
 * 1）哈希表中数据分布是不连续的，在迭代器初始化的过程中必须先跳转到第一个非空数据节点
 * 2）当迭代器的下标到达当前桶的链表末尾时，迭代器下标跳转到下一个非空桶的第一个数据节点
 */

class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private boolean label = false;  //为了ensureCapacity，
    private static int length;          //为了ensureCapacity,删除原来节点，再添加，根据是否有新的length计算 index

    public int size() {
        return size;
    }

    class Node<K, V> {
        protected K key;
        protected V value;
        protected int hash;
        protected Node<K, V> next;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    public MyHashMap(int capacity) {
        table = new Node[capacity];
    }

    public int hash(Object key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }


    public Iterator<Node<K, V>> iterator() {
        return new Itr();
    }

    class Itr implements Iterator<Node<K, V>> {
        private int currentIndex;//当前桶的位置
        private Node<K, V> nextNode;//返回的下一个数据节点
        private Node<K, V> currentNode; //上一次next返回的数据节点

        public Itr() {
            if (MyHashMap.this.isEmpty()) {
                return;
            }
            for (int i = 0; i < table.length; i++) {

                currentIndex = i;
                Node<K, V> firstNode = table[i];
                if (firstNode != null) {
                    nextNode = firstNode;
                    return;
                }

            }
        }

        @Override
        public boolean hasNext() {
            currentNode = nextNode;//修改
            return nextNode != null;
        }

        @Override
        public Node<K, V> next() {
            //返回下一个数据节点
            currentNode = nextNode;
            //nextNode指向自己的next
            nextNode = nextNode.next;
            if (nextNode == null) {
                //说明当前桶的链表已经遍历完毕
                //寻找下一个非空的桶
                for (int i = currentIndex + 1; i < MyHashMap.this.table.length; i++) {
                    //设置当前桶位置
                    currentIndex = i;
                    Node<K, V> firstNode = MyHashMap.this.table[currentIndex];
                    if (firstNode != null) {
                        nextNode = firstNode;
                        break;
                    }
                }
                //nextNode保存的就是下一个非空的数据节点
            }
            return currentNode;
        }

        @Override
        public void remove() {
            if (currentNode == null) {
                return;
            }
            K currentKey = currentNode.key;
            MyHashMap.this.remove(currentKey);
            currentNode = null;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void ensureCapacity() {

        label = true;//告诉put在进行扩容，size不变
        Node<K, V>[] tmp = table;
        table = Arrays.copyOf(table, table.length * 2);
        for (int i = 0; i < tmp.length; i++) {
            Node<K, V> firstNode = tmp[i];
            if (firstNode == null) {
                continue;
            }
            while (firstNode != null) {
//                先删除后添加
                length = tmp.length;//更新，表示扩容时间
                remove(firstNode.key);//
                size++;//把数量加回来

                put(firstNode.key, firstNode.value);
                firstNode = firstNode.next;
            }
        }

    }

    public void resize() {
        //扩容桶table
        Node<K, V>[] newTable = new Node[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            //将oldTable中每一个位置映射到newTable中
            rehash(i, newTable);
        }
        this.table = newTable;
    }

    public void rehash(int index, Node<K, V>[] newTable) {
        Node<K, V> currentNode = table[index];//与我的方法的不同之处在于table的最后修改时间，我的实时修改，老师的最后更改
        if (currentNode == null) {
            return;
        }

        Node<K, V> lowListHead = null; //低位的头
        Node<K, V> lowListTail = null; //低位的尾
        Node<K, V> highListHead = null; //高位的头
        Node<K, V> highListTail = null; //高位的尾

        //currentNode表示oleTable下index位置中当前节点
        while (currentNode != null) {
            //当前节点在newTable中的位置
            int newIndex = newTable.length - 1 & hash(currentNode.key);

            if (newIndex == index) {
                //映射到原先下标处
                if (lowListHead == null) {
                    lowListHead = currentNode;
                    lowListTail = currentNode;
                } else {
                    lowListTail.next = currentNode;
                    lowListTail = lowListTail.next;
                }
            } else {
                //newIndex与index不等，映射到高位下标处
                if (highListHead == null) {
                    highListHead = currentNode;
                    highListTail = currentNode;
                } else {
                    highListTail.next = currentNode;
                    highListTail = highListTail.next;
                }
            }
            currentNode = currentNode.next;
        }
        //将lowList head->tail之前的节点链接到index位置
        if (lowListHead != null) {
            newTable[index] = lowListHead;
            lowListHead.next = null;
        }

        //将highList head->tail之前的节点链接到index+table.length位置
        if (highListHead != null) {
            newTable[index + this.table.length] = highListHead;
            highListHead.next = null;
        }
    }


    public void put(K key, V value) {
        //确定所要添加元素的位置
        int hash = hash(key);//散列码
        int index = table.length - 1 & hash;//确定的位置

        //newNode
        //table[index]已经存在数据
        //table[index]不存在数据
        Node firstNode = table[index];
        if (firstNode == null) {
            table[index] = new Node(key, value, hash);
            if (!label) {   //判断是否是扩容的时候，不是的话加一，是的话不加
                size++;
            }
        } else {
            Node<K, V> tmp = firstNode;
            while (tmp.next != null && !tmp.key.equals(key)) {
                tmp = tmp.next;
            }
            if (tmp.next == null) {
                if (tmp.key.equals(key)) {
                    tmp.value = value; //新值替换旧值
                } else {
                    tmp.next = new Node(key, value, hash);
                    size++;
                }
            } else {
                tmp.value = value;
            }
        }
    }

    public boolean remove(K key) {
        int hash = hash(key);
        int index;
        if (length == 0) {
            index = table.length - 1 & hash;
        } else {
            index = length - 1 & hash;
            length = 0;
        }
        Node<K, V> firstNode = table[index];

        if (firstNode == null) {
            return false;
        } else {
            if (firstNode.next == null) {
                if (firstNode.key.equals(key) && firstNode.hash == hash) {
                    //为什么判断key是否相等的同时还需要判断散列码？
                    //key是否相等还要判断hashCode是否相等，因此可能存在key用quals()方法比较相同的两个元素
                    // （hashCode肯定不同）
                    table[index] = null;
                    size--;
                    return true;
                }
            }
            Node<K, V> tmp = firstNode.next;
            while (tmp != null) {
                if (tmp.key.equals(key) && tmp.hash == hash) {
                    //tmp之前节点的next指向tmp.next
                    size--;
                    firstNode.next = tmp.next;
                    tmp = null;
                    return true;
                } else {
                    firstNode = tmp;
                    tmp = tmp.next;
                }
            }
            /*if(tmp.key.equals(key) && tmp.hash == hash){
                //tmp之前节点的next指向tmp.next
                size--;
                tmp = null;
                return true;
            }*/
        }
        return false;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = table.length - 1 & hash;
        Node<K, V> firstNode = table[index];

        if (firstNode == null) {
            return null;
        } else {
            Node<K, V> tmp = firstNode;
            while (tmp.next != null) {
                if (tmp.key.equals(key) && tmp.hash == hash) {
                    //tmp之前节点的next指向tmp.next
                    return tmp.value;
                } else {
                    tmp = tmp.next;
                }
            }
            if (tmp.key.equals(key) && tmp.hash == hash) {
                //tmp之前节点的next指向tmp.next
                return tmp.value;
            }
        }
        return null;
    }
}

/**
 * 1)、iterator删除函数不行
 * 2）、ensureCapacity（）暂时没问题
 */
public class MapTest {
    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<String, Integer>(8);

        map.put("张三", 98);
        map.put("李四", 100);
        map.put("王五", 77);
        map.put("李帅", 666);

        System.out.println("大小：" + map.size());

        System.out.println("获取李四的键值：" + map.get("李四"));

        System.out.println("删除李四：" + map.remove("李四"));

        System.out.println("大小：" + map.size());

        MyHashMap.Itr itr1 = (MyHashMap.Itr) map.iterator();
        while (itr1.hasNext()) {
            MyHashMap.Node entry = itr1.next();
            System.out.println(entry.key + "::" + entry.value);
        }

        map.resize();
        System.out.println("+++++++++");
//        map.ensureCapacity();

        MyHashMap.Itr itr = (MyHashMap.Itr) map.iterator();
        int label = 0;
        System.out.println("用迭代器的方式删除第一个后：");
        //迭代器指示获取了原数组的备份，删除操作在迭代器显示不出来
        System.out.println("大小：" + map.size());
        while (itr.hasNext()) {
            label++;
            if (label == 1) {
                itr.remove();
            }
            MyHashMap.Node entry = itr.next();
            System.out.println(entry.key + "::" + entry.value);
        }

        //验证时迭代时的remove是否成功
        MyHashMap.Itr itr2 = (MyHashMap.Itr) map.iterator();
        System.out.println("验证：");
        while(itr2.hasNext()){
            MyHashMap.Node entry = itr2.next();
            System.out.println(entry.key+"::"+entry.value);
        }
//        Iterable;
        /*System.out.println("---------------");
        System.out.println("大小："+map.size());

        System.out.println("获取李四的键值："+map.get("李四"));

        System.out.println("删除李四："+map.remove("李四"));

        System.out.println("大小："+map.size());*/
    }
}