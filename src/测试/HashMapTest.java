package 测试;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 *实例化两个Student对象，另两个学生对象当中的内容都相同
 *然后将两个对象对象都添加到hasMap集合对象当中
 *另后一个学生对象对前一个学生对象进行覆盖操作
 */
public class HashMapTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1=new Student("zhou");
        Student s2=new Student("zhou");
        Map<Student, String> students=new HashMap<Student,String>();
        /**
         * 当前所实例化的两个学生对象当中的名字完全相同所以将之认为是同一个key值来将之存放到hashMap当中来实现s2对s1的覆盖操作
         * 但是在进行输出之后发现s1的value依然是AA并没有被s2当中的BB进行覆盖
         * 现要解决这一问题，使得map集合认为st1对象和st2两个对象在key当中认为是同一个key
         */
        students.put(s1,"AA");
        students.put(s2,"BB");
        System.out.println(students.get(s1));
        /**
         * 要解决上述问题首先要明白当对象存放到集合当中的时候hashMap是如何判断两个对象是否是相同的key的：
         *
         * hashMap会先调用key对象当中的equals方法来和已存在的key进行比较，当值为false的时候则认为是两个不同的key值
         * 当equals方法相同的时候
         * 		比较当前key和已经存在的key对象的hashCode值是否是相同的
         * 			当hashCode也相同的时候则认为当前所进行比较的两个key对象是完全相同的
         * 				此时后一个key对象当中的value将会对以存在的key所对应的value进行覆盖操作
         * 			当hashCode不同的时候则认为两个key是不同的，将会为当前key的value开辟新的空间来进行内容的存放操作
         * 所以：
         * s2存放到hashMap当中的时候首先会调用其equals方法来和s1来进行比较
         * 		对student对象当中的equals方法来进行重写另其和参数对象当中的同名属性值进行比较，只有当两个对象当中的属性值都完
         * 		全相同的时候，则认为两个对象是相等的。
         * 当两个对象使用equals方法比较返回为true的时候，接下来要对两个对象的hashCode值进行比较
         * 		此时则要对student对象当中的hashCode方法进行重写
         * 		此时所返回的hashCode值将不能够是当前实例对象本身的hashCode，因为当前进行比较的两个对象的hashCode值是不相同的
         * 		选择两个对象都相同的某一属性值然后将其所对应的hashCode做为对象的hashCode进行返回
         * 		此时两个对象的hashCode都是name所对应的hashCode，当name相同的时候两个对象的hashCode也将相同
         */
        System.out.println("s1.equals(s2)="+s1.equals(s2));
        System.out.println("s1.hashCode="+s1.hashCode());
        System.out.println("s2.hashCode="+s2.hashCode());
        /**
         * 此时在对p1所对应的value值进行输出的时候发现值为BB而非AA
         * 表明p1当中所对应的value值被p2所对应的value值进行了替换操作
         * 此时在map集合对象当中相当于两个key和同一个value进行了映射操作
         */
        System.out.println(students.get(s1));
        System.out.println(students.get(s2));
    }

}