package Metaphase02;

import java.util.*;


/**
 * HashMap源码分析
 * 类的继承关系
 * 类的属性
 * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;   16
 * static final int MAXIMUM_CAPACITY = 1 << 30;
 * static final float DEFAULT_LOAD_FACTOR = 0.75f;
 * static final int TREEIFY_THRESHOLD = 8; 桶上的节点个数大于8时会转为红黑树
 * static final int UNTREEIFY_THRESHOLD = 6; 桶上的绩点个数小于6时会转为链表
 * static final int MIN_TREEIFY_CAPACITY = 64; 桶中结构转化为红黑树对用的table的最小大小
 * transient Node<K,V>[] table; 存储元素的数组 总是2的幂次方
 * transient Set<Map.Entry<K,V>> entrySet;  哈希表中节点的集合
 * transient int size;
 * transient int modCount;
 * int threshold; 临界值
 * final float loadFactor;
 * 类的构造函数
 * 类的put方法
 *
 * HashMap使用自定义类型作为key
 * Iteratable
 * Iterator
 */
class Person{
    private String id;

    public Person(String id){
        this.id = id;
    }

    public Person() {

    }

    @Override
    public int hashCode(){
        return id != null?id.hashCode():0;
    }


    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person)o;
        if(id != null ? id.equals(person.id):person.id!=null) {
            return true;
        }
        return false;
    }

    //反射
    public void printGetClass(){
        System.out.println("反射的方式获取class类：");
        System.out.println(getClass());
        System.out.println(getClass().getClass());
        System.out.println(getClass().getClass().getClass());
        System.out.println(getClass().getClass().getClass().getClass());
        System.out.println(getClass().getName());
    }
}
public class 源码分析 {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("001"), "tulun1");
        map.put(new Person("002"), "tulun2");
        map.put(new Person("003"), "tulun3");

        System.out.println(map.get(new Person("001")));
        System.out.println(map.get(new Person("002")));
        System.out.println(map.get(new Person("003")));

        Person p = new Person();
        p.printGetClass();

//        ArrayList;
//        AbstractMap;
//        Hashtable;
//        HashMap;
//        Properties;
//        Vector;
//        LinkedList;
//        Iterable;

    }
}
