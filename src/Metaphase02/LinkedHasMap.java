package Metaphase02;

import java.util.*;

/**
 * LinkedHashMap/TreeeMap/HashMap
 */
public class LinkedHasMap {
    static class testComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name1 ", "tulun1");
//        map.put("name2",  "tulun2");
//        map.put("name3",  "tulun3");
//
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, String> entry = iterator.next();
//            System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
//        }
//
//        LinkedHashMap<String, String> lmap = new LinkedHashMap<>();
//        lmap.put("name1 ", "tulun1");
//        lmap.put("name2",  "tulun2");
//        lmap.put("name3",  "tulun3");
//
//        Iterator<Map.Entry<String, String>> literator = lmap.entrySet().iterator();
//        while(literator.hasNext()){
//            Map.Entry<String, String> entry = literator.next();
//            System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
//        }

//        LinkedHashMap<String, String> lmap1 = new LinkedHashMap<String, String>(16,0.75f, true);//LRU
//        lmap1.put("name1 ", "tulun1");
//        lmap1.put("name2",  "tulun2");
//        lmap1.put("name3",  "tulun3");
//        System.out.println("开始的顺序");
//        Iterator<Map.Entry<String, String>> literator1 = lmap1.entrySet().iterator();
//        while(literator1.hasNext()){
//            Map.Entry<String, String> entry = literator1.next();
//            System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
//        }
//
//        lmap1.get("name1");//通过get方法，将key为name1放到表尾
//        System.out.println("通过get方法，将key为name1放到表尾");
//
//        Iterator<Map.Entry<String, String>> literator2 = lmap1.entrySet().iterator();
//        while(literator2.hasNext()){
//            Map.Entry<String, String> entry = literator2.next();
//            System.out.println("key: "+entry.getKey()+", value: "+entry.getValue());
//        }

        TreeMap<Integer, String> map  = new TreeMap<>();
        map.put(1, "tulun1");
        map.put(0, "tulun2");
        map.put(3, "tulun3");

        TreeMap<Integer, String> map1  = new TreeMap<Integer, String>(new testComparator());
        map.put(1, "tulun1");
        map.put(0, "tulun2");
        map.put(3, "tulun3");

    }
}
