package 断言;

public class AssertionTest {

    public static void main(String[] args) {

        boolean isSafe = false;
        /*assert isSafe;
        System.out.println("断言通过!");*/


        assert isSafe : "Not safe at all";
        System.out.println("断言通过!");

        //Junit可替代
    }
}
