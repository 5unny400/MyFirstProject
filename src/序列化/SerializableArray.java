package 序列化;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Linkedlist
 * HashMap自行实现序列化与反序列化
 */
public class SerializableArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("实现");
        list.add("序");
        list.add("需要");

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src" +
                    "\\序列化\\mySerialize.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.printf("Serialized list is saved in mySerialize.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
