package Metaphase01;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 快速失败机制的避免方式：
 * CopyOnWriteArrayList与ArrayList不同：
 *
 * (01) 和ArrayList继承于AbstractList不同，CopyOnWriteArrayList没有继承于AbstractList，它仅仅只是实现了List接口。
 * (02) ArrayList的iterator()函数返回的Iterator是在AbstractList中实现的；而CopyOnWriteArrayList是自己实现Iterator。
 * (03) ArrayList的Iterator实现类中调用next()时，会“调用checkForComodification()比较‘expectedModCount’和‘modCount’的大小”；
 * 但是，CopyOnWriteArrayList的Iterator实现类中，没有所谓的checkForComodification()，更不会抛出
 * ConcurrentModificationException异常！
 */
public class TestDemo05 {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        new MyThread1(list).start();
        new MyThread2(list).start();
    }
}

class MyThread1 extends Thread {
    private List<Integer> list;

    public MyThread1( List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer integer : list) {
            System.out.println("MyThread1 大小：" + list.size() + " 当前值：" + integer);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 extends Thread {
    private List<Integer> list;

    public MyThread2( List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        for (int i = 5; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
            System.out.println("MyThread2 大小：" + list.size());
        }
    }
}