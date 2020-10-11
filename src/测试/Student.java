package 测试;

public class Student {
    private String name;

    public Student(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //对当前Student对象当中的方法进行重写,将要进行比较的object对象先强制转变为student对象
        Student stu = (Student) obj;
//		另当前对象当中的指定属性和参数对象当中的指定 属性值进行比较
        boolean flag = this.name.equals(stu.getName());
        if (flag) {
            return true;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        if (this.name != null) {
            return name.hashCode();
        } else
            return super.hashCode();
    }
}