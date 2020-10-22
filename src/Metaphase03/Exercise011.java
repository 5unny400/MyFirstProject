package Metaphase03;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise011 {
    public static void main(String[] args) throws IOException {
        File file1 = new File(".\\IOExercise\\IOExercise.txt");
        File file2 = new File(".\\IOExercise\\IOExercise1.java");
        File file22 = new File(".\\IOExercise\\IOExercise2.java");
        File file3 = new File(".\\IOExercise\\IOExercise.html");
        File file4 = new File(".\\IOExercise\\IOExercise.py");
        if(!file1.isFile()){
            file1.createNewFile();
        }
        if(!file2.isFile()){
            file2.createNewFile();
        }
        if(!file22.isFile()){
            file22.createNewFile();
        }
        if(!file3.isFile()){
            file3.createNewFile();
        }
        if(!file4.isFile()){
            file4.createNewFile();
        }
        //我的路径
        //String fileName = "D:\program\ProgramOfIdea\MyJavaStudy2\IOExercise";
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个合法文件夹路径：");
        String fileName = scan.nextLine();

        start(fileName);
    }

    private static void start(String fileName) {
        if (!check(fileName)) {
            System.out.println("请输入正确的文件格式！");
            return;
        }
        //创建文件对象
        File file = new File(fileName);
        //不存在就创建
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println(fileName + "是否存在：" + file.isDirectory());

        String arr = Arrays.toString(file.list());
        System.out.println("该文件夹下的文件：" + arr);

        //输出Java文件
        outJavaFile(arr);
    }

    public static void outJavaFile(String arr) {
        System.out.println("该文件夹下的java文件：");
        String[] arrJava = arr.split(",");
        if (arrJava != null) {
            for (int i = 0; i < arrJava.length; i++) {
                String[] tmp = null;
                if (i == 0) {
                    tmp = arrJava[i].split("\\[");
                    arrJava[i] = tmp[1];
                    tmp = tmp[1].split("\\.");
                } else if (i == arrJava.length - 1) {
                    tmp = arrJava[i].split("\\]");
                    arrJava[i] = tmp[0];
                    tmp = tmp[0].split("\\.");
                } else {
                    tmp = arrJava[i].split("\\.");
                }
                //System.out.println(arrJava[i]);
                if (tmp != null && tmp[1].equals("java")) {
                    System.out.println(arrJava[i]);
                }
            }
        }
    }

    public static boolean check(String path) {
//文件的正则表达式
//        String regPath = "([\\s\\w+:]*?/?(/.+/)?)((\\w+)\\.(\\w+))$";
//      文件夹的正则表达式
        String regPath = "([\\s\\w+:]*?/?(/.+/)?)(\\w+)$";
        path = path.replace('\\', '/');
        //Pattern pattern = Pattern.compile(regPath);
        //System.out.println(pattern.pattern()+"????");
        return Pattern.matches(regPath, path);
    }
}
