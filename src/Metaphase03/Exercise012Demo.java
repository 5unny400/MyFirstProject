package Metaphase03;

import java.io.File;

public class Exercise012Demo {

    /**
     * 删除本地文件夹及包含文件
     * @param dir
     */
    public static void deleteLocalDir(String dir){
        File file=new File(dir);
        if(file.exists()){
            //delete()方法不能删除非空文件夹，所以得用递归方式将file下所有包含内容删除掉，然后再删除file
            if(file.isDirectory()){
                File[] files=file.listFiles();
                for(File f : files){
                    deleteLocalDir(f.getPath());
                }
            }
            file.delete();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        File file = new File(".\\IOExercise2");

        if(!file.exists()){
            file.mkdirs();
        }

        System.out.println(file.getPath()+"是否存在："+file.exists());

        System.out.println("十二秒后开始删除操作！");
        Thread.sleep(12000);
        deleteLocalDir(file.getPath());
    }
}
