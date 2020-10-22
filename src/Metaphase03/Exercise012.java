package Metaphase03;

import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;

public class Exercise012 {
    Stack<String> stack = new Stack<>();
    private File file;

    public Exercise012(File file) {
        this.file = file;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //先创建多级目录
        File file = new File(".\\IOExercise2");
        File file2 = new File(".\\IOExercise2\\test21");
        File file3 = new File(".\\IOExercise2\\test31");
        File file4 = new File(".\\IOExercise2\\test21\\test211.txt");
        File file5 = new File(".\\IOExercise2\\test21\\test212.txt");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file3.exists()) {
            file3.mkdirs();
        }
        if (!file4.exists()) {
            file4.createNewFile();
        }
        if (!file5.exists()) {
            file5.createNewFile();
        }

        //删除file
        Exercise012 exercise012 = new Exercise012(file);
        exercise012.startDelete();
    }

    private void startDelete() throws InterruptedException {
        if (!check(file)) {
            System.out.println("请输入正确的文件格式！");
            return;
        }

        System.out.println("12秒后开始删除操作！");
        Thread.sleep(12000);

        stack.push(file.getPath());
        //开始删除多级文件夹以及文件
        deleteInStack();
    }

    public void deleteInStack() {
        while(!stack.isEmpty()) {
            File tmp = new File(stack.peek());
            if (tmp.isDirectory()) {
                String[] arr = tmp.list();
                if (arr == null || arr.length == 0) {
                    //开始删除
                    stack.pop();
                    tmp.delete();

                } else {
                    for (int i = 0; i < arr.length; i++) {
                        stack.push(tmp.getPath() + "\\" + arr[i]);
                    }
                }
            } else {
                stack.pop();
                tmp.delete();
            }
        }
    }

    private boolean check(File file) {
        String path = file.getAbsolutePath();
        System.out.println(path);
        String regPath = "([\\s\\w+:]*?/?(/.+/)?)(\\w+)$";
        path = path.replace('\\', '/');
        return Pattern.matches(regPath, path);
    }
}
