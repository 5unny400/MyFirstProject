package 单元测试;

import org.junit.Test;

public class UnitTest {
    private  String name;
    private String num;

    public UnitTest(){

    }

    @Test
    public void Tes(){
        System.out.println(this.getClass().getName()+":"+this.name+" "+this.num);
    }
}
