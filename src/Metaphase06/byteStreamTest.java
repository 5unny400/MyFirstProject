package Metaphase06;

import java.io.*;

/**
 * 字节流
 *
 */
public class byteStreamTest {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase06\\test01.jpg";
        String fileName2 = "D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase06\\result01.jpg";
        String fileName3 = "D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase06\\result02.jpg";
        File file = new File(fileName);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);

        if (!file2.exists()) {
            file2.createNewFile();
        } else {
            System.out.println("result01.jpg存在！");
        }

        if (!file3.exists()) {
            file3.createNewFile();
        } else {
            System.out.println("result02.jpg存在！");
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);

        System.out.println("1正在读取复制......");
        int tmp;
        while ((tmp = fileInputStream.read()) != -1) {
            fileOutputStream.write(tmp);
        }
        fileInputStream.close();
        fileOutputStream.close();

        System.out.println("2正在读取复制......");
        byte[] tmpByte = new byte[1024];
        int byteRead = 0;
        byteStreamTest.showAvailableBytes(fileInputStream2);
        while ((byteRead = fileInputStream2.read(tmpByte)) != -1) {
            fileOutputStream2.write(tmpByte,0,byteRead);
        }
        fileInputStream2.close();
        fileOutputStream2.close();
    }


    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
