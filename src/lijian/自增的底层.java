package lijian;

public class 自增的底层 {
    public static void main(String[] args) {
        int i = 0;
        i = ++i;
        i = i++;
        int j = i;
        System.out.println(j);
    }
}
