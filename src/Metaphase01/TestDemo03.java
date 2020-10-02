package Metaphase01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList是线程非安全的
 * 1)modCount定义于AbstractList，（ArrayList继承AbstractList，）存储结构修改次数
 * 2）fast-fail机制  ArrayList的自我保护机制
 * 使用迭代器遍历时，如果调用集合add/remove方法修改集合的结构，则会抛出ConcurrentModificationexception
 * ConcurrentModificationexception
 *
 * non-fastfail机制
 * 练习1、copyOnWriteArrayList  如何实现非快速失败机制？？？
 * 练习2、Vector底层源码，主要看属性，构造函数、增删改查方法、明白ArrayList与Vector之间的区别与联系
 * （底层数据结构、效率、扩容机制、是否线程安全）
 *
 */
class MIterator<E> implements Iterable{
    private E[] elements;//存放元素的容器
    private int size; //存放元素的个数

    public MIterator(E[] elements){
        this.elements = elements;
        this.size = elements.length;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;
            @Override
            public boolean hasNext() {
                return (cursor+1) < size;
            }

            @Override
            public Object next() {
                return elements[++cursor];
            }
        };
    }
}
class TestDemo3 {
    public static void main(String[] args) {
//        String[] array = new String[]{"1", "2", "3", "4", "5"};
//        MIterator myIterator = new MIterator(array);
//
//        Iterator itr = myIterator.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(23);
        list.add(65);
        list.add(22);

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            itr.remove(); //此时会报异常
            System.out.println(itr.next());
            //list.remove(3);//抛异常 迭代器在迭代的过程中，集合的结构不能够发生改变
            itr.remove();//正常运行
        }
        System.out.println(list.toString());

        /*for(int x:list){
            System.out.println(x+' ');
            list.remove(3);//迭代的过程总不能修改ArrayList的结构
        }
        System.out.println(list.toString());*/
    }
}
