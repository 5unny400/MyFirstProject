package Metaphase01;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;

/**
 * Queue接口
 * ArrayQueue --》栈
 * add(E)/offer(E)
 * remove()/pooll()
 * element()/peek()
 *
 * Deque接口  双端队列
 * Queue()    Dequeue
 * add()        addLast()
 * offer()      offerLast()
 * remove()     removeFirst()
 * poll()       pollFirst()
 * element()       getFirst()
 * peek()       peekFirst()
 *
 * Stack    Deque
 * push(E)  addFirst(E)
 * 无        offerFirst()
 * pop()    removeFirst()
 * 无        pollFirst（）
 * peek()   peekFirst()
 * 无        getFirst()
 *
 *
 * 队列   ArrayDeque  ArrayList
 *
 * ArrayDeque -> 循环数组（数据结构）
 *
 * 1、ArrayDeque LinkedList的区别与练习联系
 * 2、课后作业2：修改MyArrayDeque
 * 3、课后作业3：预习ArrayDeque源码
 *
 */

class MyArrayDeque<E>{
    private E[] elements;
    private int head;   //永远指向队头
    private int tail;   //永远指向循环数组中下一个可添加元素的位置
    private static int default_size = 5;

    public MyArrayDeque(){
        this(5);
    }
    public MyArrayDeque(int capacity){
        elements = (E[])new Object[capacity];
    }

    public void add(E value){
        //默认队尾添加
        if((tail+1)%(elements.length-1) == head){
            elements = Arrays.copyOf(elements,elements.length<<1);
        }
        elements[tail] = value;
        tail = (tail+1)%(elements.length-1);
    }

    public E remove(){
        //默认队头删除
        if(head == tail){
            throw new UnsupportedOperationException("the queue is empty!");
        }
        E result = elements[head];
        elements[head] = null;
        head = (head+1)%(elements.length-1);
        return result;
    }

    public E get(){
        return elements[head];     //有可能是空值
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i =head;i != tail;i = (i+1)%(elements.length-1)){
            str.append(elements[i]+" ");
        }
        return str.toString();
    }
}
public class TestDemo06 {
    public static void main(String[] args) {

        /*//LinkedList的源码
        LinkedList list = new LinkedList();

        Stack stack = new Stack();
        stack.push(2);
*/
//        Deque<String> queue = new ArrayDeque<>();
//        //添加元素
//        queue.addFirst("first1");
//        queue.addLast("last1");
//        queue.offerFirst("offerfirst1");
//        queue.offerLast("offerlast1");
//        queue.addFirst("a");
//        queue.addFirst("b");
//        queue.addFirst("c");
//
//        //删除元素
//        System.out.println(queue.removeFirst());
//        System.out.println(queue.removeLast());
//        System.out.println(queue.pollFirst());
//        System.out.println(queue.pollLast());
//
//        //获取元素
//        System.out.println(queue.getFirst());
//        System.out.println(queue.getLast());
//        System.out.println(queue.peekFirst());
//        System.out.println(queue.pollLast());
        /*ArrayDeque s = new ArrayDeque();
        MyArrayDeque<Integer> queue = new MyArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(8);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.get());

        System.out.println(queue.toString());
*/
        ArrayDeque demo = new ArrayDeque();
        List lst = new LinkedList();
//        AbstractSequentialList;
//        Collection;
//        PriorityQueue;
//        ArrayDeque;
//        DelayQueue;
//        CopyOnWriteArrayList;
    }
}
