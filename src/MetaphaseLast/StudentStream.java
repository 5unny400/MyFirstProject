package MetaphaseLast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student{
    private Integer id;
    private String name;
    private Integer age;
    private Double score;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public Student(Integer id, String name, Integer age, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
}

/**
 *  1）通过集合创建Stream
 *  filter接受lambda表达式，从流中进行过滤
 *  limit 使得元素不超过给定值
 *  skip 跳过元素，返回一个扔掉前n个元素的流
 *  distinct 筛选  通过流中元素的hashCode和equals去除重复元素
 *  2）过滤所有年龄大于22岁的同学
 *  3）删选出前3条数据
 *  4）跳过前2个元素
 *  5）过滤重复的元素
 *   map 接受一个lambda表达式 使得表达式中的逻辑作用于每一个元素
 *   flatMap 接受一个函数作业参数，将流中的每个值都换成另外一个流，然后所有的流连接为一个流
 *   6）筛选出所有的年龄，再过滤年龄大于20的
 *   sorted - 自然排序
 *   sorted - 自定义排序
 *   7）指定Comparable，对流中的对象按照成绩进行排序
 */
public class StudentStream {
    public static List<Student> getStdents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "小明", 23, 89.5));
        students.add(new Student(2, "小花", 22, 99.5));
        students.add(new Student(3, "小蓝", 20, 79.5));
        students.add(new Student(4, "小惠", 19, 90.5));

        return students;
    }


    public static void testDemo(){
        List<String> myList = Arrays.asList("a1", "a2", "a3", "a5", "a0", "c5");
        myList
                .stream() //创建流
                .filter(s->s.startsWith("a")) //过滤出以c为前缀的字符串
                .map(String::toUpperCase) //转换为大写
                .sorted() //排序
                .forEach(System.out::println);//for 循环打印

    }

    public static void main(String args[]){

        //集合创建Stream
        ArrayList<Student> students  = (ArrayList<Student>) getStdents();
        //1.1顺序流
        Stream<Student> stream = students.stream();
        //1.2并行流
        Stream<Student> stream1 = students.parallelStream();
        //2、数组创建流
        int[] array = {15,48,75,29};
        IntStream stream2 = Arrays.stream(array);

        //3、通过Stream.of
        Stream<String> stream3 = Stream.of("789","485","442");
        //4、Stream.iterate()创建一个无限流
        //从0开始 每隔取一个放到流中
        Stream<Integer> stream4 = Stream.iterate(0, t-> t+5);

        //过滤所有年龄大于22岁的同学
        students.stream().filter(s-> s.getAge() > 22).forEach(System.out::println);
        System.out.println();
        //筛选出前3条数据
        students.stream().limit(3).forEach(System.out::println);
        System.out.println();

        //跳过前2个元素
        students.stream().skip(2).forEach(System.out::println);
        System.out.println();

        //过滤重复的元素
        students.stream().distinct().forEach(System.out::println);
        System.out.println();

        //筛选出所有的年龄，再过滤年龄大于20的
        Stream<Integer> ageStream = students.stream().map(Student::getAge);
        ageStream.filter(age -> age>20).forEach(System.out::println);
        System.out.println();

        //指定Comparable，对流中的对象按照成绩进行排序
        students.stream().sorted((s1, s2)->(int)((s1.getScore())-s2.getScore())).forEach(System.out::println);



    }

}
