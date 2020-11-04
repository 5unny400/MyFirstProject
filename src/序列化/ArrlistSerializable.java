package 序列化;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrlistSerializable extends ArrayList implements Serializable {
    public String name = "hello";;
    private int array[];
    private transient int size = 2;         //transient作用防止敏感词在网络上被存下来
    private static int InitNum = 9;

    private void test(){
        System.out.println("将ArrayList写入磁盘。");
    }

    public int getSize() {
        return size;
    }

    public int getInitNum() {
        return InitNum;
    }

}
