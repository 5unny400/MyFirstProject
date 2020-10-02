package Metaphase01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * 迭代器接口
 * Iterator
 * 隐藏集合类的底层实现，通过hasNext和next方法得到集合当中的对象
 * iterator() 返回Iterator对象
 * hasNext() 判断当前集合是否含有下一个可迭代的元素
 * next()    返回当前集合下一个可迭代元素
 *
 * 课后作业：
 * 1、ArrayList和数组的区别和联系
 * 2、自定义迭代器代码完成
 *
 * 周四中午12点前提交
 */

class MyIterator<E> implements Iterable<E>{
    private E[] elements;//存放元素的容器
    private int size; //存放元素的个数
    private final static int default_size = 5;

    public MyIterator(E[] elements){
        this.elements = elements;
        this.size = elements.length;
    }

    public MyIterator(){
        this.elements = (E[])new Object[default_size];
        size = 0;
    }
    public void add(E value){
        ensureCapacity();
        elements[size++] = value;
    }

    private void ensureCapacity() {
        if(size== elements.length){
            this.elements = Arrays.copyOf(elements,elements.length+(elements.length>>1));
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return index+1 < size;
            }

            @Override
            public E next() {
                index++;
                return elements[index];
            }
        };
    }
}
public class Test02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        for(Integer i: list){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("迭代器的使用:");
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }

        System.out.println();
        System.out.println("自定义迭代器的实现");
        //为什么反省E不起作用
        String[] array = {"s","p"};
        MyIterator X = new MyIterator(array);
        Iterator<String> st = X.iterator();
        while(st.hasNext()){
            System.out.print(st.next()+" ");
        }

        System.out.println();
        MyIterator<Integer> myIterator = new MyIterator<>();
        myIterator.add(1);
        myIterator.add(2);
        Iterator<Integer> it = myIterator.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
