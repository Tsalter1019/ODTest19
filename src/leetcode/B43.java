package leetcode;
import java.math.BigDecimal;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
//
//
//
// 示例 1:
//
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:房源
//
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 200
// num1 和 num2 只能由数字组成。
// num1 和 num2 都不包含任何前导零，除了数字0本身。
//
// Related Topics 数学 字符串 模拟 👍 1038 👎 0

public class B43 {
    public static void main(String[] args) {
        String num1="498828660196";
        String num2="840477629533";
        System.out.println(new B43().multiply(num1,num2));
    }
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        long[] arr = new long[m];
        long[] brr = new long[n];
        long a =0;
        long sum=0;
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            arr[i] = Integer.parseInt(ch1[i]+"");

        }
        for(int i=0;i<ch2.length;i++){
            brr[i] = Integer.parseInt(ch2[i]+"");
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<brr.length;j++){
                if(ch1.length-j-1>=0){

                }
            }
        }
        //if(ch1.length-i-1>=0){
        //    a+=Integer.parseInt(ch1[i]+"")*Math.pow(10,ch1.length-i-1);
        //}

        return (a*sum)+"";
    }
}