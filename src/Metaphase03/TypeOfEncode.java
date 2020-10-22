package Metaphase03;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 *
 */
public class TypeOfEncode {
    public static void main(String[] args) {
        //得到系统默认的编码方式
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
        System.out.println("+++++++++++++++++++++++++++");
        SortedMap<String,Charset> sortedMap = Charset.availableCharsets();
        Iterator<Map.Entry<String,Charset>> iterator = sortedMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Charset> entry = iterator.next();
            System.out.println(entry.getKey()+":: "+entry.getValue());

        }

    }
}
