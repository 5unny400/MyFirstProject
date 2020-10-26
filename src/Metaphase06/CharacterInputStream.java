package Metaphase06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 字符流，读取字符的IO流
 *
 */
public class CharacterInputStream {

    public static void main(String[] args) throws IOException {
        readInFile();

        writeInFile();
    }

    public static void readInFile(){
        try {
            FileReader fileReader = new FileReader("test03.txt");
            fileReader.read();
            int tmp;
            Charset charset = Charset.defaultCharset();
            System.out.println("当前系统默认编码："+charset);
            //System.out.println();
            while((tmp = fileReader.read())!=-1){
                System.out.print((char)tmp);
            }
            //关闭流对象
            fileReader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeInFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("test03.txt",true);


            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
