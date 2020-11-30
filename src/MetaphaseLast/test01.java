package MetaphaseLast;

import com.sun.org.apache.xpath.internal.operations.Plus;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 *java8 新特性
 * lambda 简洁代码实现一个功能  主要是为了支持函数式编程
 * expression
 */
public class test01 {


    public static void main(String[] args) {

        //x+y
        //有问题》》
        //int sum = (int x,int y) -> x + y;

        Inteface1 f1=(int x,int y)->{System.out.println(x+y);};
        f1.test(3,4);



        String[] str = {"SDFGHJRTYU","SDFGHJRTYU","SDFGHJRTYU","SDFGHJRTYU"};
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });

        Arrays.sort(str,(o1,o2)->o1.toLowerCase().compareTo(o2.toLowerCase()));
    }
}
