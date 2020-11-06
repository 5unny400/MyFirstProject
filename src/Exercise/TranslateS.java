package Exercise;

import java.util.Scanner;
import java.util.Stack;

public class TranslateS {
    private char[] arr = {
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
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

    public void getResult(int index, Stack stack) throws ClassCastException {
        if (index < 0) {
            //出栈的顺序，输出栈内整型值对应的字符
            int i = stack.size();
            while (i>0) {
                i--;
                System.out.print(arr[(int) stack.get(i)]);
            }
            System.out.print(" ");
        }else {

            int x = Integer.parseInt(String.valueOf(array[index]));
            if (index == array.length - 1) {
                //第一个字符直接入栈,整型栈
                stack.push(x);
                //递归
                getResult(index - 1, stack);
            } else {
                String tmp = array[index] + String.valueOf(stack.peek());
                int y = (Integer.parseInt(tmp));
                if (y > 9 && y < 26) {
                    //结合了一个字符，就要出栈顶数字
                    stack.pop();
                    //入新结合数值
                    stack.push(y);
                    //递归
                    getResult(index - 1, stack);
                    //出结合的数值
                    stack.pop();
                    //入原来的各位数值
                    stack.push(Integer.parseInt(String.valueOf(array[index+1])));
                }
                //递归，仅仅单个数值
                stack.push(x);
                getResult(index - 1, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一段数字密文：");
        String str = scan.nextLine();
        TranslateS translate = new TranslateS(str);
        */
        TranslateS translateS = new TranslateS();
        System.out.println("可能结果如下：");

        Stack stack = new Stack();
        translateS.getResult(translateS.array.length - 1, stack);
    }
}
