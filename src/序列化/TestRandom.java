package 序列化;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;

public class TestRandom {
    public static void main(String[] args) {
        String fileName = "D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src" +
                "\\序列化\\testRandom";
        RandomAccessFile randomFile = null;
        //在1-n之中找到两个重复的数字   SortedSet sortedSet;
        try {

            randomFile = new RandomAccessFile(fileName, "r");
            int fileLength = (int) randomFile.length();
            int beginIndex = (int) (Math.random()*fileLength);
            randomFile.seek(beginIndex);

            byte[] bytes = new byte[50];
            int byteread = 0;
            byteread = randomFile.read(bytes);
            if (byteread != -1) {
                System.out.println("随机读取一段文字:");
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        addRandomly(fileName);
    }

    public static void addRandomly(String fileName){
        RandomAccessFile randomFile = null;
        try {
            randomFile = new RandomAccessFile(fileName, "rws");
            int beginIndex = 256;
            randomFile.seek(beginIndex);

            System.out.println();
            String str = "西安图论科技有限公司";
            System.out.println(str+" 已写入文件！");
            randomFile.write(str.getBytes());

            //输出验证是否插入成功
            randomFile.seek(beginIndex);
            byte bytes[] = new byte[30];
            int label = randomFile.read(bytes);
            if(label != -1){
                System.out.write(bytes, 0, label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
