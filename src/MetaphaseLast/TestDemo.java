package MetaphaseLast;

interface Inteface1{
    //可以不用abstract修饰
    public abstract void test(int x,int y);
    //public void test1();//会报错,不能有两个方法,尽管没有使用abstract修饰
    public boolean equals(Object o);//equals属于Object的方法,所以不会报错
}

class Test{
    public static void main(String args[]){
        Inteface1 f1=(int x,int y)->{System.out.println(x+y);};
        f1.test(3,4);

        Inteface1 f2=(int x,int y)->{ System.out.println("Hello Lambda!\t the result is " +(x+y));};
        f2.test(8,4);
    }
}