package Metaphase01;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *LinkedList
 * 链表与数组的最大区别：存储空间是否连续
 */
class MyLinkedList<E>{
    private int size = 0;   //链表的元素个数
    private Node head,tail;

    static class Node<E> {
        private E data;
        private Node pre;
        private Node next;

        public Node(E data, Node<E> pre, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }
    }
        public void add(E value){
            //默认尾插法
            Node<E> node = new Node<>(value, tail, null);
            if(head ==null||tail == null){
                head = node;
            }else{
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public void add(int index , E value){
            //判断index的合法性
            if(index < 0||index > size){
                return;
            }else if( index == size){
                //尾插法
                add(value);
            }else{
                Node<E> succ = findNodeByIndex(index);
                Node<E> succPre = succ.pre;
                Node<E> newNode = new Node<>(value);
                if(succPre == null){
                    succ.next = newNode;
                }else{
                    succPre = newNode;
                }
            }

        }
        public Node<E> findNodeByIndex(int index){
            Node<E> tmp = head;
            for(int i =0;i<size;i++){
                tmp = tmp.next;
            }
            return tmp;
        }
        public Node<E> findNodeByValue(E value){
            Node<E> tmp = head;
            while(tmp != null){
                if(tmp.data.equals(value)){
                    return tmp;
                }
                tmp = tmp.next;
            }
            return null;
        }
    public boolean remove(E value){
        //删除元素所在的节点
        Node<E> succ = findNodeByValue(value);
        if(succ == null){
            return false;
        }
        Node<E> succPrev = succ.pre;
        Node<E> succNext = succ.next;

        if(succPrev == null){
            //所要删除的是第一个节点
            head = succNext;
        }else{
            succPrev.next = succNext;
            succ.pre = null;
        }

        if(succNext == null){
            //所要删除的是最后一个节点
            tail = succPrev;
        }else{
            succNext.pre = succPrev;
            succ.next = null;
        }
        succ.data = null;//方便垃圾回收
        size--;
        return true;
    }

    public E set(int index, E newValue){
        if(index < 0 || index >= size){
            return null;
        }
        Node<E> succ = findNodeByIndex(index);
        E oldValue = succ.data;
        succ.data = newValue;
        return oldValue;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return findNodeByIndex(index).data;
    }
        @Override
        public String toString(){
            StringBuilder strs = new StringBuilder();
            Node<E> temp = head;
            while(temp != null){
                strs.append(temp.data+" ");
                temp = temp.next;
            }
            return null;
        }

}
public class TestDemo04 {
    public static void main(String[] args) {
        System.out.println();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addLast(8);

        list.removeFirst();

        list.remove(2);
        System.out.println(list.get(2));

        list.set(2,10);

        for(Integer x: list){
            System.out.println(x+" ");
        }

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next()+" ");
        }




    }
}
