package Metaphase02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","s");
        map.put("b","ss");
        map.put("c","sss");
        map.put("d","ssss");

        //先封装成set集合
        Iterator<Map.Entry<String,String>> itr = map.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String,String> entry = itr.next();
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }
    }
}
