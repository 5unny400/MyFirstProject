package Metaphase03;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * IO Input Output
 * 1、基本概念
 *  文件分为文本文件和二进制文件（其实都是以二进制方式存的）
 *
 *  2、File类
 *  File可以通过文件路径来创建File实例
 *  File file = new File("fileName");
 *
 *  路径：相对路径和绝对路径
 *  绝对路径：C://xxx/xxx/xxx
 *  相对路径：.表示当前目录    ..表示上一级目录
 *
 *  boolean exists 表示当前路径下是否存在
 *  boolean isFile 判断当前路径是否是一个文件
 *  boolean isDirectory 判断当前路径是否是一个文件夹
 *  boolean isHidden  判断当前路径是否是隐藏文件
 *  boolean delete 直接删除当前文件
 *  boolean createNewFile 创建新文件
 *  file.mkdir 创建目录
 *  file.getAbsolutePath  获取文件的绝对路径
 *  file.list 获取当前路径下的所有文件
 *  file.getName 获取文件名
 *  file.listFiles 获取当前路径下的所有文件
 */
public class IoTest01 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase03\\IOtest01.txt");
        File file2 = new File(".\\IOtest02.txt");

        //1、创建文件，相对，绝对路径的方式
        file.createNewFile();
        file2.createNewFile();
        //检查是否存在文件，不存在创建新文件
        System.out.println("是否存在文件"+file.isFile());
        if(!file.exists()){
            file.createNewFile();
        }
        //2、单级目录      aa
        File file3 = new File("D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase04");
        file3.mkdir();
        //创建多级目录        aaa/bbb/cc
        File file4 = new File("D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase05\\IoTest");
        file4.mkdirs();
        //删除文件夹和目录
        if(file.delete()) {  //仅删除了单级目录
            System.out.println("删除 D:\\program\\ProgramOfIdea\\MyJavaStudy2\\src\\Metaphase03\\IOtest01.txt ！");
        }//？？？？如何删除多级目录

        //获取文件信息，文件名，文件大小，文件的绝对路径，
        System.out.println("file3.getPath()："+file3.getPath());
        System.out.println("file3.getAbsolutePath()："+file3.getAbsolutePath());
        System.out.println("file3.getName()："+file3.getName());
        System.out.println("file3.length()："+file3.length());
        System.out.println("file3.getFreeSpace()："+file3.getFreeSpace());
        System.out.println("file3.getParentFile()："+file3.getParentFile());
        System.out.println("file3.getParent()："+file3.getParent());      //获取父路径

        //目录或者文件的判断
        System.out.println("file2是一个文件？"+file2.isFile());
        System.out.println("file2是一个目录？"+file2.isDirectory());
        System.out.println("file2是一个隐藏文件夹: "+file2.isHidden());
        System.out.println("file2.isAbsolute(): "+file2.isAbsolute());
        //获取目录
        System.out.println("file4.list():"+file4.list());
        System.out.println(Arrays.toString(file4.list()));
        System.out.println("file4.listFiles()："+file4.listFiles());
        System.out.println(Arrays.toString(file4.listFiles()));
    }
}












