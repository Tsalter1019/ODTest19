package leetcodeDaily;


import java.util.Arrays;

public class A2578 {
    public static int splitNum(int num) {
        String str = num+"";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String s1 = "";
        String s2 = "";
        for(int i=0;i<ch.length;i++){
            if(i%2==0){
                s1+=ch[i];
            }else{
                s2+=ch[i];
            }
        }
        return Integer.parseInt(s1)+Integer.parseInt(s2);
    }

    public static void main(String[] args) {
        System.out.println(splitNum(4512));
        System.out.println(splitNum(21354));
        System.out.println(splitNum(213));
        System.out.println(splitNum(958351976));
        System.out.println(splitNum(1234567));
        System.out.println("----------");
        System.out.println(splitNum1(4512));
        System.out.println(splitNum1(21354));
        System.out.println(splitNum1(213));
        System.out.println(splitNum1(958351976));
        System.out.println(splitNum1(1234567));
    }

    public static int splitNum1(int num) {
        char[] stnum = Integer.toString(num).toCharArray();
        Arrays.sort(stnum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stnum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stnum[i] - '0');
            } else {
                num2 = num2 * 10 + (stnum[i] - '0');
            }
        }
        return num1 + num2;
    }

}