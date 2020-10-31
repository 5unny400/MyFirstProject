package Metaphase06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 字符流 读写字符的IO流
 * Reader && FileReader
 * Writer && FileWriter
 *
 * FileReader读取字符
 * 注意：
 * 1）read方法读取字符char，一个字符可能占用1个字节，2个字节或者3个字节
 * 2）占用字节的个数由编码表所决定
 * 3）read最终返回int，如果读取到的字符用2个字节表示，前2个字节即前16位可以补0
 * 4）FileReader中的构造方法调用的是FileInputStream
 *
 * FileWriter写入字符
 * 课堂练习：
 * 拷贝a.txt到b.txt
 * 1）一个一个字符去拷贝
 * 2）开辟一个缓存数组
 */
public class CharacterStream {

    public static void main(String[] args) throws IOException {
        readInFile();
        writeInFile();


        copy();
    }

    private static void copy() {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("test03.txt");
            writer = new FileWriter("b.txt");
            //一个一个字符拷贝
//            int tmp = 0;
//            while((tmp = reader.read()) != -1){
//                writer.write(tmp);
//            }
            //缓冲数组
            char[] buf = new char[256];
            int len = 0;
            while((len = reader.read(buf)) != -1){
                writer.write(buf, 0, len);
                //字符数组 写入
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readInFile() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("test03.txt");
            int tmp=-1; //实际是去存储四个字节

            Charset charset = Charset.defaultCharset();
            System.out.println("当前系统默认编码："+charset);

            while((tmp = fileReader.read())!=-1){
                System.out.print((char)tmp);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭流对象
            fileReader.close();
        }
    }


    private static void writeInFile() throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test03.txt",true);
            fileWriter.write("hello world!");

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            fileWriter.close();

        }
    }
}
