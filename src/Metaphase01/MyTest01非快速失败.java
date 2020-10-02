package Metaphase01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyTest01非快速失败 {
    public static void main(String[] args) {

        Vector vector = new Vector();
        ArrayList arrayList = new ArrayList<>();

        List<Integer> list = new CopyOnWriteArrayList<>();
        for(int i =0;i<5;i++){
            list.add(i);
        }
        new MyThread1(list).start();
        new MyThread2(list).start();

        Iterator<Integer> itr = list.iterator();    //只是获取了一个副本，并不能实时与原来的数组同步
        while(itr.hasNext()){
            System.out.println(itr.next()+" ");
        }

    }
    static class MyThread1 extends Thread {
        private List<Integer> list;

        public MyThread1( List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer integer : list) {
//                虽然，获取到了更新后的ArrayList的大小；但是，当前（因为是用的还是迭代器）迭代的结果
//                并不是更新后的arrayList；
                System.out.println("MyThread1 大小：" + list.size() + " 当前值：" + integer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThread2 extends Thread {
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
}
