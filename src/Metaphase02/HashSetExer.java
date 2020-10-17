package Metaphase02;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExer {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        //HashSet集合的元素要求不重复，无序，底下还有一个TreeSet
        while(hashSet.size()<10) {
            int i = (int) (Math.random()*20+1);
            hashSet.add(i);
        }

        for(int x : hashSet){
            System.out.println(x+" ");
        }
    }
}
