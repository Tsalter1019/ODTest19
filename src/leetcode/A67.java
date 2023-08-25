package leetcode;


//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//输入:a = "11", b = "1"
//输出："100"
//输入：a = "1010", b = "1011"
//输出："10101"
// 1 <= a.length, b.length <= 10⁴
// a 和 b 仅由字符 '0' 或 '1' 组成
// 字符串如果不是 "0" ，就不含前导零

public class A67 {
    public static void main(String[] args) {

    }
    public String addBinary(String a, String b) {
        char[] arr = new StringBuffer(a).reverse().toString().toCharArray();
        char[] brr = new StringBuffer(b).reverse().toString().toCharArray();
        char[] result = new char[Math.max(arr.length,brr.length)];
        for(int i=0;i<Math.max(arr.length,brr.length);i++){

        }
        return "";
    }
}