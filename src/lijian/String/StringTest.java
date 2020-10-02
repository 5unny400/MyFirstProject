package lijian.String;


public class StringTest {

    public static void main(String[] args) {
        String string2 = "ab"+"c";
        String string4 = "c";
        String string5 = "ab"+"c";

        String string6 = "ab" + new String("c");
        String string66 = "ab" + new String("c");
        String string10 = "ab"+string4;
        String string1010 = "ab"+string4;

        String s = "ab";
        String me = s + string4;
        System.out.println(string2==me);

        System.out.println("string2==string5："+(string2 == string5));
        System.out.println("  "+(string4 == new String("c")));
        System.out.println("  "+(new String("c") == new String("c")));

        System.out.println("string2==string6："+(string2==string6));
        System.out.println(string2.equals(string6));
        System.out.println("string6==string66："+(string6==string66));   //新建的地址

        System.out.println("string2 == string10："+(string2 == string10));
        System.out.println(string2.equals(string10));

        System.out.println("string6 == string10："+(string6 == string10));
        System.out.println(" "+(string6.equals(string10)));

        System.out.println("string1010 == string10："+(string1010 == string10));
        System.out.println("string1010 == string10："+(string1010.equals(string10)));
    }
}
