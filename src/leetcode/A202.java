package leetcode;


import java.util.HashSet;

public class A202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = sous(n);
        }
        return n==1;
    }
    public static int sous(int n){
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(new A202().isHappy(7));
    }
}