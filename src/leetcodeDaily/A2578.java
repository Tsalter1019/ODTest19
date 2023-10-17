package leetcodeDaily;


import java.util.Arrays;

public class A2578 {
    public static int splitNum(int num) {
        char[] ch = (num+"").toCharArray();
        int[] arr = new int[ch.length];
        for(int i=0;i<ch.length;i++){
            arr[i] = Integer.parseInt(ch[i]+"");
        }
        Arrays.sort(arr);
        int min = 0;
        for(int i=0;i<arr.length;i++){

        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(splitNum(4512));
    }
}