package Exercise;

/**
 * 给定一个数字，按照如下规则翻译为字符串，0翻译为"a",1翻译为"b",25翻译为"z"。这样一个数字有可能存在多个翻译，
 * 例如，12258有5种不同的翻译，分别是bccfi, bwfi,bczi,mcfi,mzi等等。
 * 1 2 2 5 8
 * 递归：把大规模问题转为小规模问题
 * f(i) =
 */

public class TranslateLi {
    private static char[] chars = {
            'a','b','c','d',
            'f','g','h','i',
            'j','k','l','m',
            'n','o','p','q',
            'r','s','t','u',
            'v','w','x','y',
            'z','!','@','#'
    };

    private static String string = "";

    private static void ad(int i){
        if (i<10) {
            if (i==0) {
                System.out.println(string);
                return;
            }
            else {
                string = chars[i-1]+ string;
                System.out.println(string);
                return;
            }
        }
        int i1 = i%10;
        int i2 = i/10%10;


        if(i2>2) {
            string = chars[i1-1]+ string;

        }
        if (i2==0||i2==1||i2==2) {
            i1 = i1 + i2*10;
            string = chars[i1-1]+ string;
        }
        ad(i/10);
        ad(i/100);
    }

    public static void main(String[] args) {
        ad(12258);
    }



}
