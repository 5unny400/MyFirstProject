package Metaphase02;

import java.util.HashMap;
import java.util.Map;

/**
 * 散列表，很具关键值（key）进行访问的数据结构，也就是说，通过Key映射到表中的一个位置
 * 来获取记录，加快了查找速度，这个映射的函数叫做散列函数，映射的数据结构叫散列表
 *
 *
 * 寻址容易，插入删除也容易的数据结构
 *ASCII码：
 * a-z:97-122
 * A-Z:65-90
 *
 *  * 张三 15376467384   ZS  90+83 = 173
 *  * 李四 18548787753   LS  76+83 = 159
 *  * 王五 19847875837   WW  87+87 = 174
 *  * 张帅 14338477838   ZS  90+83 = 173
 *
 * class People{
 *     private String name;
 *     private String number;
 * }
 * 链表O(n)
 * 二叉排序树O(log2 N)
 * 散列表key - value  O(1)
 * key -> hash函数 - 》name所对应的首字母ASCII码的值 -》散列
 * 哈希冲突！！！！
 * 通过以下方式构造哈希函数：
 * 1、直接定址法： key address(key) = a*key + b
 * 2、平方取中法 key  108 109 110 =>108^2 109^2 110^2
 * 3、折叠法       key =>拆分为几部分  区域号 书架号 图书编号
 * 4、除留取余法    key =>hash表的最大长度m,取不大于m的质数 key%质数
 *
 *解决哈希冲突
 *1、开放地址法 12 13 25 23 hash表的长度为
 *2、链地址法
 *
 * HashMap 的使用:
 * HashMap基于散列表（哈希表）非同步实现的，哈希表对应的接口是Map接口（非线程安全）
 * jdk1.8之前 HashMaori都是采用数组+链表实现的，即采用链地址法处理哈希冲突，不同的key值可以得到同一个Hash码（散列码），
 * 同一个hash码的节点存储在一个链表中，但是当链表中的元素越来越多的时候，通过key去查找的效率反而从O(1)--O(n).
 * 在jdk1.8中:采用链表+数组+红黑树实现，当前链表的长度超过8的时候，将链表转换成红黑树；红黑树中的元素个数小于6时将红黑树
 * 转换成链表
 *
 *
 */
public class collection {
    public static void main(String[] args) {
        //声明HashMap对象
        Map<String,Integer> map = new HashMap<>();
        //添加元素
        map.put("张三",98);
        map.put("李四",100);
        map.put("王五",77);
        map.put("虎子",88);

        //根据key获取记录
        System.out.println("获取李四的键值："+map.get("李四"));
        //根据key记录
        System.out.println("删除李四："+map.remove("李四"));
        //获取map记录里的元素个数
        System.out.println("大小："+map.size());
        //判断map集合中是否包含键值为key的记录
        System.out.println("是否包含张三这个key："+map.containsKey("张三"));
        System.out.println("是否包含zhangsan这个key："+map.containsKey("zhangsan"));
        System.out.println("判断是否为空："+map.isEmpty());
        //清除map
        System.out.println("清空！");
        map.clear();
        System.out.println("判断是否为空："+map.isEmpty());

    }
}
