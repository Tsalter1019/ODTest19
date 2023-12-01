package Test.java;

//  代码块的执行顺序题
public class Person {
    private static int count;
    private String name;
    public Person(){
        count++;//创建对象p1-------2--c     //创建对象p2-------3--c
        System.out.println("Constructor executed.");
    }
    {
        name = "John";//创建对象p1-------2--b    //创建对象p2-------3--b
        System.out.println("Non-static code block executed.");
    }
    static {//首先执行------1
        count = 1;
        System.out.println("Static code block executed.");
    }

    public static void main(String[] args) {
        Person p1 = new Person();//创建对象p1-------2--a
        Person p2 = new Person();//创建对象p2-------3--a
        System.out.println("Total count: " + count);//最后输出
    }
}