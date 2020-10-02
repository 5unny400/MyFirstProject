package Metaphase01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Vector;

/**
 * 自定义比较器MyComparator
 *
 */
class myPriorityQueue<E extends Comparable<E>>{    //类型擦除为Comparable，变为可比较对象
    private E[] queue;          //存放元素的容器
    private int size;       //有效元素个数
    private static int  DEFAULT_CAPACITY = 5;

    public myPriorityQueue(){
        this(DEFAULT_CAPACITY);
    }

    public myPriorityQueue(int initCapacity){
        queue = (E[]) new Comparable[initCapacity];
    }

    public E element(int index){
        if(index <0||index>=size){
            return null;
        }else {
            return queue[index];
        }
    }
    public void add(E value){
        ensureCapacity();
        //添加一个元素后仍然保持是小根堆
        //盘满 扩容
        if(size == queue.length){
            queue = Arrays.copyOf(queue, queue.length*2);
        }
        //当前队列为空
        if(size == 0){
            queue[0] = value;
            size++;
        }else{
            //当前队列不为空，需要调整当前对列为小根堆
            adjust(size,value);
            size++;
        }
    }

    private void ensureCapacity() {
        if(size == queue.length){
            queue = Arrays.copyOf(queue,queue.length*2);
        }
    }

    //模拟调整小根堆
    public void adjust(int index, E value){
        while(index > 0){
            int parentIndex = (index - 1)/2;
            if(parentIndex>=0&&queue[parentIndex].compareTo(value) > 0){
                queue[index] = queue[parentIndex];
                index = parentIndex;
            }else{
                break;
            }
        }
        queue[index] = value;
    }


    public boolean remove(){
        //空的队列
        if(size == 0){
            return false;
        }
        //当前队列只有一个元素
        int index = --size;
        if(index == 0){
            queue[index] = null;
            return true;
        }
        //多个元素
        queue[0] = null;
        adjustDown(0, queue[index]);
        return true;
    }
    //上往下调整
    private void adjustDown(int index, E value) {
        int leftChild = index*2+1;
        while(leftChild < size){
            int rightChild = leftChild +1;
            if(rightChild<size&&queue[leftChild].compareTo(queue[rightChild])>0){
                leftChild++;
            }
            if(value.compareTo(queue[leftChild])<=0){
                break;
            }
            queue[index] =queue[leftChild];
            index = leftChild;
            leftChild = leftChild*2+1;
        }
        queue[index] = value;
    }
    /*public E remove(){
        if(size == 0){
            return null;
        }else{
            int s = --size;
            E result = (E) queue[0];
            System.arraycopy(queue,1,queue,0,size);
            queue[size] = null;
            return result;
        }
    }*/

    public E peek(){
        if(size == 0){
            return null;
        }else{
            return queue[0];
        }
    }

    @Override
    public String toString() {

        String strs = new String();
        for(int i = 0;i<size;i++){
            strs = strs + (Object) element(i) +" ";
        }
        /*return "myPriorityQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", size=" + size +
                '}';*/
        return strs;
    }

    public int size() {
        return size;
    }
}

public class PriorityQue {
    public static void main(String[] args) {

        myPriorityQueue<Integer> queue = new myPriorityQueue<>();
        queue.add(2);
        queue.add(5);
        queue.add(3);
        queue.add(7);
        queue.add(9);
        queue.add(4);
        queue.add(6);

        System.out.println(queue.peek());
        System.out.println();

//        for(int i =0;i<queue.size();i++){
//            System.out.print(queue.element(i)+" ");
//        }
        System.out.println(queue);

        System.out.println();
        int m = queue.size();
        for(int i =0;i < m-1;i++) {
            System.out.print(queue.remove()+"  ");
        }

        System.out.println();
        System.out.println(queue.peek());
    }
}
