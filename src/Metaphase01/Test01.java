package Metaphase01;

import java.util.*;

/**
 * 集合框架库
 * 1、collection 存储一个元素的集合
 * 2、Map 存储键值对的集合
 * <p>
 * 常用的集合 ArrayList LinkedList HashSet LinkedHashSet
 * <p>
 * 集合接口：Collection Map List Set Queue Iterator
 * Map 接口存储的键值对对象
 * Queue继承Collection先进先出
 * Set接口继承Collection 集合元素不允许重复
 * List继承Collection  有序 允许重复
 *
 *
 * ArrayList 底层基于数组，数组在内存中实力按需分配的地址空间，对数组的升级，长度是动态的
 *面试题1：ArrayList与数组的区别和联系
 * 1）数组的优点；数组的缺点（插入删除比较麻烦，数组的长度固定）：
 *2）ArrayList的优点（对数组的升级，是一个动态的数组，提供了一些方便的呢方法）
 *
 *
 * 自定义ArrayList，提供了add(E value)/remove(E value)/set(index,value)/get(index)/
 * contains(value)/size()/isEmpty()
 *
 *数组的拷贝：
 * 1)、destArray = Arrays.copyOf(src,newLength)
 * 2)Object.clone();
 * 3)System.arraycopy(src, srcstart, destArray, destStart, length);
 *
 *
 * Iterator接口;迭代器
 * foreach()
 *
 * Iterator()返回Iterator对象
 * hasNext()    判断集合是否有下一个可迭代对象
 * next()       返回当前集合下一个元素
 *
 */
class MyArrayList<E>{
    private E[] elements;//存放元素的容器
    private int size;       //实际的元素个数
    private final static int defaultCapacity = 5;//默认的初始化参数

    public MyArrayList(int capacity){
        elements = (E[])new Object[capacity];
    }
    public MyArrayList(){
        this(defaultCapacity);
    }

    public void ensureCapacity(){
        if(size==elements.length){
            this.elements = Arrays.copyOf(this.elements,2*elements.length);
        }else{
            return;
        }
    }
    public void add(E value){
        //确保空间足够
        ensureCapacity();
        elements[size++] = value;
    }

    public boolean remove(E value){
        if(size == 0){
            throw new UnsupportedOperationException("the collection has no capacity!");
        }
        /*int i;
        for(i =0;i<size;i++){
            if(elements[i] == value){
                for(int j = i;j<size-1;j++){
                    elements[j] = elements[j+1];
                }
                size--;
                i--;
            }
        }
        if(elements[size-1]==value){
            size--;
        }*/
        for(int i =0;i<this.elements.length;i++){
            if(value.equals(this.elements[i])){
                System.arraycopy(this.elements,i+1,this.elements,i,size-1-i);
                this.elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public boolean checkIndex(int index){
        if(index < 0||index > elements.length){
            throw new UnsupportedOperationException("the index is illegal!");
        }
        return true;
    }
    public boolean set(int index, E value){
        try{
            checkIndex(index);
            elements[index] = value;
            return true;
        }catch(UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public E get(int index){
        try{
            checkIndex(index);
            return elements[index];
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean contains(E value){
        if(size == 0){
            return false;
        }
        for(int i=0; i<size; i++){
            if(this.elements[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public String toString(){
        StringBuilder strs = new StringBuilder();
        for(int i=0;i<size;i++){
            strs.append(elements[i]+" ");
        }

        return strs.toString();
    }
}
public class Test01 {
    public static void main(String[] args) {

        Collection collection = new Collection() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        /*List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");

        list.remove("123");

        System.out.println(list.size());

        String[] s = (String[])list.toArray();

        list.set(0,"tulun");*/



        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        System.out.println(list.toString());

        list.remove("6");
        list.remove("10");

        System.out.println(list.toString());

        list.set(0, "100");
        list.set(5, "tulun");
        System.out.println(list.toString());

        System.out.println(list.get(-1));
        System.out.println(list.get(5));

        System.out.println(list.contains("tulun"));

        System.out.println(list.isEmpty());

        System.out.println(list.size());

        /*List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");

        list.remove("123");

        System.out.println(list.size());

        String[] s  = (String[])list.toArray();

        list.set(0, "tulun");*/
    }

}
