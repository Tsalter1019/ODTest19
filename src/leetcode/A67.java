package leetcode;


//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//输入:a = "11", b = "1"
//输出："100"
//输入：a = "1010", b = "1011"
//输出："10101"
// 1 <= a.length, b.length <= 10⁴
// a 和 b 仅由字符 '0' 或 '1' 组成
// 字符串如果不是 "0" ，就不含前导零

import java.util.Arrays;

public class A67 {
    public static void main(String[] args) {
        System.out.println(new A67().addBinary("11101","1111"));
    }
    public String addBinary(String a, String b) {
        int al=a.length();
        int bl=b.length();
        int len = Math.max(al,bl);

        if(len==al){
            String aa = a+"0";
            String bb = b;
            for(int i=0;i<al-bl;i++){
                bb+="0";
            }
            bb+="0";
            char [] temp = new char[al+1];
            Arrays.fill(temp,'0');
            for(int i=0;i<aa.length();i++){
                for(int j=i;j<bb.length();j++){
                    if(aa.charAt(i)=='0'&&bb.charAt(j)=='0'){
                        temp[i] = '0';
                    }else if(((aa.charAt(i)=='0'&&bb.charAt(j)=='1')||(aa.charAt(i)=='1'&&bb.charAt(j)=='0'))&&temp[i]=='0'){
                        temp[i] = '1';
                    }else if(((aa.charAt(i)=='0'&&bb.charAt(j)=='1')||(aa.charAt(i)=='1'&&bb.charAt(j)=='0'))&&temp[i]=='1'){
                        temp[i] = '1';
                        temp[i] = '0';
                    }else if(aa.charAt(i)=='1'&&bb.charAt(j)=='1' &&temp[i]=='0'){
                        temp[i] = '0';
                        temp[i+1] = '1';
                    }else{
                        temp[i] = '1';
                        temp[i+1] = '1';
                    }
                    break;
                }
            }
            temp[temp.length-1] = '1';
            System.out.println("eqweq");
        }

        return "1";
    }
}