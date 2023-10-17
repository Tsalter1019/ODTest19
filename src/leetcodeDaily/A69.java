package leetcodeDaily;


public class A69 {
    public static void main(String[] args) {
        System.out.println(new A69().mySqrt(8));
    }
    public int mySqrt(int x) {
        double s = Math.sqrt(x);
        return (int)s;
    }
}