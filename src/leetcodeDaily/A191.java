package leetcodeDaily;


public class A191 {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new A191().hammingWeight(00000000000000000000000000001011));
    }
}