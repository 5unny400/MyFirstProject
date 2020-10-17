package collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.WeakHashMap;

/**
 * HashMap博客
 *
 * 1、WeakHashMap 特殊HashMap
 *   WeakHashMap的键关联的对象是弱引用对象
 *
 *   static class Entry<K,V> extends WeakReference<Object> Entry继承自WeakReference
 *
 * java当中四种引用
 * 1、强引用
 *    通过new出来对象所关联的引用称之为强引用，只要强引用存在，当前对象不会被回收
 * 2、软引用
 *    通过SoftReference类实现，在系统内存即将要溢出的时候，才会回收软引用对象
 * 3、弱引用
 *    通过WeakReference实现，只要发生GC，被弱引用关联的对象就会被回收掉
 * 4、虚引用
 *    通过PhantomReference实现，无法通过虚引用获取对象实例，唯一作用就是在这个对象
 *    被回收时，能够收到一个通知
 */
public class 引用 {
    public static Object key1;
    public static Object key2;
    public static Object key3;

    public static WeakHashMap<Object, Integer> getWeakHashMap(){
        WeakHashMap<Object, Integer> map = new WeakHashMap<>();
        key1 = new Object();//强引用
        key2 = new Object();
        key3 = new Object();

        map.put(key1, 1);
        map.put(key2, 1);
        map.put(key3, 1);
        return map;
    }

    public static void printWeakHashMap(WeakHashMap<Object, Integer> map){
        System.out.println("================");
//        for(Object key: map.keySet()){
//            System.out.println("key: "+key+"， value: "+map.get(key));
//        }
        Iterator<Object> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj+":: "+map.get(obj));
        }
    }
    public static void main(String[] args) {
        //虚引用
//        PhantomReference ptr = new PhantomReference(new Object(),new ReferenceQueue());
//        System.gc();
//        if(ptr.isEnqueued()){
//
//        }

//        WeakHashMap<Object, Integer> map = getWeakHashMap();
//        printWeakHashMap(map);
//
//        System.gc();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        printWeakHashMap(map);
//
//        key1 = null;
//        key2 = null;
//
//        System.gc();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        printWeakHashMap(map);
    }
}
