package huaweiODTest2023AandBQuestionBank.old100;

import java.util.Scanner;

/**
 * 存在一种虚拟IPV4地址Q，由4小节组成，每节的范围为0-255，以#号间隔，虚拟IPV4地址可以转换为一个32位的整数，例如:
 * 128#0#255#255，转换为32位整数的结果为2147549183 (0x8000FFFF)
 * 1#0#0#0，转换为32位整数的结果为16777216 (0x01000000)
 *
 * 现以字符串形式给出一个虚拟IPv4地址，限制第1小节的范围为1~128，即每一节范围分别为(1~128)#(0~255)#(0~255)#(0~255)，
 * 要求每个IPv4地址只能对应到唯 的整数上
 * 如果是非法IPv4Q，返回invalid IP
 * 输入描述
 * 输入一行，虚拟IPV4地址格式字符串
 * 输出描述
 * 输出一行，按照要求输出整型或者特定字符
 */
public class Iptoint {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();*/
        String s = "100#101#1#5";
        System.out.println(solution(s));
    }
    public static String solution(String strings){
        String[] ss = strings.split("#");
        int len = ss.length;
        long count = 0;
        boolean isF = true;

        if(len == 4){
            for(int i =0;i<len;i++){
                int n = Integer.parseInt(ss[i]);
                if(i==0 && (n<1 || n>128)) {
                    isF = false;
                    break;
                }else if(n<0 || n>255){
                    isF = false;
                    break;
                }
                count += n << (8 * (3 - i));
            }
        } else {
            isF = false;
        }
        if(isF) {
            return count+"";
        }else{
            return "invalid IP";
        }
    }
}