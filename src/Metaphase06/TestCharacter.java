package Metaphase06;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.sun.deploy.trace.Trace.flush;

public class TestCharacter {
    public static void main(String[] args) throws IOException {
        File file = new File("test03.txt");
        File file2 = new File("test031.txt");

        if(!file.exists()){
            file.createNewFile();
        }
        if(file2.exists()){
            file2.createNewFile();
        }

        TestCharacter testCharacter = new TestCharacter();
        //testCharacter.readByOneCharacter();

        testCharacter.readByCharacters();


    }

    private void readByCharacters() throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            System.out.println("开始复制。。。。");
            fileReader = new FileReader("test03.txt");
            fileWriter = new FileWriter("test031.txt");
            int tmp;
            char [] buf = new char[256];
            while((tmp=fileReader.read(buf))!=-1){
                fileWriter.write(buf,0,tmp);
            }
            System.out.println("复制完毕！");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //不关闭刘对象，内容不会刷新到磁盘上
            fileReader.close();
            fileWriter.close();

            //也可以主动刷新
            //flush();
        }

    }

    public void readByOneCharacter() throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            System.out.println("开始复制。。。。");
            fileReader = new FileReader("test03.txt");
            fileWriter = new FileWriter("test031.txt");
            int tmp;
            while((tmp=fileReader.read())!=-1){
                fileWriter.write((char)tmp);
            }
            System.out.println("复制完毕！");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileReader.close();
            fileWriter.close();
        }
    }




}
