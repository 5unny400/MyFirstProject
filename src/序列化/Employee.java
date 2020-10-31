package 序列化;

import java.io.Serializable;

//该对象可以被序列化
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;   //不能序列化
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
        + " " + address);
    }
}
