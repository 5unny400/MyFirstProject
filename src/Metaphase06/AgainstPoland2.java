package Metaphase06;

import java.util.Scanner;
import java.util.Stack;

public class AgainstPoland2 {
    char[] arr;         //默认值为空
    int j = 0;                       //后缀表达式的长度
    String[] suffix = new String[20];       //存放后缀表达式，String数组
    Stack stack = new Stack();      //用于计算后缀表达式时，用的元素符栈


    /**
     * @return
     * @Author Shenxinyuan
     * @Description //TODO
     * @Date 19:44 2020/10/25 0025
     * @Param [arr]
     **/
    public AgainstPoland2(char[] arr) {
        this.arr = arr;
    }

    //返回运算符的优先级
    public static int getPriority(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '(' || ch == ')') {
            return 3;
        } else {
            return -1;
        }
    }

    public void start() {
        change();       //得到后缀表达式
        getResult();     //
    }

    //开始计算后缀表达式
    private void getResult() {

        Stack st = new Stack(); //用于计算的临时栈
        for (int i = 0; i < j; i++) {
            int tem = 0;
            if (!suffix[i].equals("+") && !suffix[i].equals("-") && !suffix[i].equals("*") && !suffix[i].equals("/")) {
                tem = Integer.parseInt(suffix[i]);  //不是运算符就是数字String，转为整形
                st.push(tem);                   //入临时栈
            } else {
                int p = (int) st.peek();
                st.pop();
                int q = (int) st.peek();
                st.pop();
                if (suffix[i].equals("+")) {
                    st.push(q + p);
                }
                if (suffix[i].equals("-")) {
                    st.push(q - p);
                }
                if (suffix[i].equals("*"))
                    st.push((p * q));
                if (suffix[i].equals("/"))
                    st.push(q / p);
            }
        }
        //此时临时栈中的唯1一个元素就是结果，输出显示
        System.out.println("计算结果为：" + st.peek());
        st.pop();
    }

    //中缀表达式得到后缀表达式，运算符的优先级
    //利用栈
    private void change() {

        String temq = "";
        boolean label = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '+' && arr[i] != '-' && arr[i] != '*' && arr[i] != '/' && arr[i] != ' ' && arr[i] != '(' && arr[i] != ')') {
                temq += arr[i];        //如果不是运算符就是数值，运算符作为分隔数字的分隔符
                label = true;
                if (i == arr.length - 1) {
                    suffix[j] = temq;     //倒追后一个字符的时候，将数字串放入后缀表达式
                    j++;
                }
                continue;               //处理下一个字符
            } else if (label) {            //如果是运算符，并且上一个是数字才将数值放入后缀表达式
                label = false;
                suffix[j] = temq;     //将数字串放入后缀表达式
                j++;
                temq = "";    //如果遇到运算符，temq置空
            }

//            int temp = Integer.parseInt(String.valueOf(temq));
            if (arr[i] == ' ') {      //遇到空格继续处理下一个字符
                continue;
            } else if (arr[i] == '(') {
                stack.push(arr[i]); //遇到左括号入栈
            } else if (arr[i] == ')') {        //
                while ((Character) stack.peek() != '(' && !stack.isEmpty()) {
                    suffix[j] = String.valueOf(stack.peek());  //没遇到左括号就一直出栈
                    j++;
                    stack.pop();        //出栈
                }
                stack.pop();//把‘(’出栈
            } else if (stack.isEmpty() || getPriority(arr[i]) > getPriority((Character) stack.peek())) {
                //如果栈空或者优先级比栈顶元素优先级高，就入栈
                stack.push(arr[i]);
            } else if (getPriority(arr[i]) <= getPriority((Character) stack.peek())) {
                //当前字符的优先级比栈顶的低或者遇到相同优先级的，栈中元素就出栈
                //只要栈不为空且满足出栈同条件就一直出栈（左括号除外）
                if ((Character) stack.peek() == '(') {     //遇到左括号时除外
                    stack.push(arr[i]);
                    continue;                       //处理下一个字符
                }
                while (!stack.isEmpty() && getPriority(arr[i]) <= getPriority((Character) stack.peek())
                        && (Character) stack.peek() != '(') {
                    suffix[j] = String.valueOf(stack.peek());         //放入后缀表达式
                    j++;
                    stack.pop();
                }
                stack.push(arr[i]);     //将运算符入栈自然处理下一个字符
            }else{
                throw new UnsupportedOperationException("The given operator can not satisfy this appliance!");
            }
        }

        //循环结束得到后缀表达式
        //把栈中剩余的运算符出栈到后缀表达式
        while (!stack.isEmpty()) {
            suffix[j] = String.valueOf(stack.peek());
            j++;
            stack.pop();
        }
        //至此得到完整的后缀表达式
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入运算式(输入括号伪英文括号,尽量不要有空格)：");
        String str = scan.nextLine();

        //中缀表达式：9+(3-1)*3+10/2
        //后缀表达式：9 3 1 - 3 * + 10  2 / +

        //处理过程中遇到空格继续往后获取（不受空格影响），直到末尾
        AgainstPoland2 againstPoland2 = new AgainstPoland2(str.toCharArray());
        againstPoland2.start();

        System.out.println();
    }

}
