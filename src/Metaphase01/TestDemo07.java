package Metaphase01;

/**
 * 课后练习：集合部分两篇博客的总结 List(ArrayList/LinkedList/Vector)和Queue(ArrayDeque/PriortyQueue)
 *
 * 上节课作业：
 * 1、LinkedList和ArrayList的区别和联系
 * 1）实现方式（数组与链表）
 * ArrayList基于数组实现，内存中是连续的内存空间，需要维护容量大小
 * LinkedList基于双向链表实现，内存是非连续的内存空间，不需要维护容量大小
 * 2）添加删除元素
 * 3）遍历元素 for foreach 迭代器
 * 4）使用场景
 *
 * 2、修改MyArrayDeque
 *
 * 3、ArrayDeque源码
 * 双端队列 -》 双端数组
 * 1) 不允许null元素
 * 2) head指向第一个有效元素位置
 *    tail指向尾部第一个可以插入元素的空闲位置
 * 3) addFirst addLast removeFirst removeLast
 *
 * PriorityQueue 优先级队列  小根堆 数组
 *
 * 自然排序(默认) 或者 通过提供的Comparator比较器去进行排序
 * 优先级队列从头获取元素是基于自然排序或者比较器排序的最小的元素
 * PriorityBlockingQueue是线程安全的集合，用于Java多线程环境
 *
 * 使用
 * 1）不提供比较器的自然排序
 * 2) 提供比较器的示例
 *
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class People<E> extends  PriorityQueue<E>{
    private int id;
    private String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestDemo07 {
    public static void main(String[] args) {
        //匿名内部类实现一个比较器对象
        Comparator<People> idComparator = new Comparator<People>(){
            @Override
            public int compare(People o1, People o2) {
                return o1.getId() - o2.getId();
            }
        };

        //比较器使用示例 要求优先级队列按照People中的id属性去进行排序 id越小-》对象越小
        Queue<People> peopleQueue = new PriorityQueue<>(5, idComparator);
        /*peopleQueue.add(new People(11,"aa"));
        peopleQueue.add(new People(22,"bb"));
        peopleQueue.add(new People(33,"cc"));
        peopleQueue.add(new People(44,"dd"));
        peopleQueue.add(new People(55,"ee"));
        peopleQueue.add(new People(66,"ff"));*/
        for(int i =0;i<=5;i++){
            int id = (int) (Math.random()*100);
            peopleQueue.add(new People(id, "sxy"+id));
        }

        for(People p:peopleQueue){
            System.out.print(p+" ");
        }
        System.out.println();
        System.out.println();

        for(int i =0;i<=peopleQueue.size();i++){
            System.out.println(peopleQueue.remove());
        }

        /*PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.poll();*/
    }
}
