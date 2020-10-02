package lijian;

public class FanShe {
    private int age;
    private static int count = 0;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private FanShe(){
    }

    public static FanShe getFanShe(){
        return new FanShe();
    }

    public static int getCount() {
        return count;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void setCount(int count) {
        FanShe.count = count;
    }

    @Override
    public String toString() {
        return "FanShe{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
