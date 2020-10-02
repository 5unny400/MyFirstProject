package lijian;

public class Main {
    public static void main(String[] args) {
        FanShe fanShe = FanShe.getFanShe();

        FanShe fanShe1 = FanShe.getFanShe();

        fanShe1.setAge(21);

        fanShe.setCount(3);

        fanShe.setName("张三");


        System.out.println(fanShe.toString()+FanShe.getCount());


    }
}
