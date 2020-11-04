package 序列化;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializableArray {
    public static void main(String[] args) {
        ArrayList<String> list;
        File file = new File("D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src" +
                "\\序列化\\mySerialize.txt");
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<String>) in.readObject();

            if(file.exists()){
                file.delete();
            }

            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized ArrlistSerializable...");
        System.out.println(list);
    }
}
