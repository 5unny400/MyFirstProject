package Metaphase01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueUse {
    private static int findKth(int[] arr,int k){
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i:arr){
            queue.add(i);
            if(queue.size()>k){
                queue.remove();
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int[] array = {2,5,3,7,9,4,6};
        System.out.println(Arrays.toString(array));
        System.out.println("第二大的数："+findKth(array,2));
    }
}
