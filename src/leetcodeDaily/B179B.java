package leetcodeDaily;

import java.util.Map;

public class B179B {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
//        int[] arr = {34323,3432};
        System.out.println(new B179B().largestNumber(arr));
    }
    public String largestNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(whichBigger(nums[i],nums[j])){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(111);
        return "";

    }
    public static boolean whichBigger(int a,int b){
        int la = (int)(Math.log10(a)+1);
        int lb = (int)(Math.log10(b)+1);
        if(la>lb){
            int m = a;
            int n = b;
            if(m>n){
                return true;
            } else if (m<n) {
                return false;
            }else{
                m = m/(int)(Math.pow(10,lb));
                n = n/(int)(Math.pow(10,lb));
            }
        }
        return false;

    }

}
