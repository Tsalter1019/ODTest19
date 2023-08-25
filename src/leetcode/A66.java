package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A66 {
    public static void main(String[] args) {
        int[] arr = {1,0};
        int[] brr = {9,9,9,9};
        //8999
        System.out.println(new A66().plusOne(brr));
    }
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]%=10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}