package Exercise;

import java.util.Scanner;

public class TranslateS {
    private char[] arr = {
            'a', 'b', 'c', 'd','e',
            'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q',
            'r', 's', 't', 'u',
            'v', 'w', 'x', 'y',
            'z'
    };
    private char[] array;

    public TranslateS() {
        String str = "12258";
        this.array = str.toCharArray();
    }

    public TranslateS(String str) {
        this.array = str.toCharArray();
    }

    public String getResult(int index) throws ClassCastException {
        if (index < 0) {
            return "";
        }
        int x = Integer.parseInt(String.valueOf(array[index]));
        if (index == array.length - 1) {
            return getResult(index - 1) + arr[x];
        } else {
            String tmp = array[index] + String.valueOf(array[index + 1]);
            int y = (Integer.parseInt(tmp));
            if (y > 9 && y < 26) {
                return getResult(index - 1) + arr[y];
            }

            return getResult(index - 1) + arr[x];
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一段数字密文：");

        TranslateS translateS = new TranslateS();
        System.out.println("可能结果如下：");
        System.out.println(translateS.getResult(translateS.array.length - 1) + " ");
    }
}
