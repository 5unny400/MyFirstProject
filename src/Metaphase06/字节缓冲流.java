package Metaphase06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class 字节缓冲流 {
    public static void main(String[] args) throws Exception {
        //创建缓冲字节输入流对象指定数据源
        BufferedInputStream inStream = new BufferedInputStream(new FileInputStream("D:\\program\\ProgramOfIdea" +
                "\\MyJavaStudy2\\src\\Metaphase06\\test01" +
                ".jpg"));
        //创建缓冲字节输出流对象指定数据源
        BufferedOutputStream otStream = new BufferedOutputStream(new FileOutputStream("20201114.jpg"));
        //读写数据
        //定义长度
        byte[] bytes = new byte[1024];
        //定义长度
        int len;
        while ((len = inStream.read(bytes)) != -1) {
            //导出数据
            otStream.write(bytes, 0, len);
        }
        //关闭资源
        otStream.close();
        inStream.close();

    }
}
