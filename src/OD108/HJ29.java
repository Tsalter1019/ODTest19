package OD108;

/**
 * 对输入的字符串进行加解密，并输出。
 * 加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 解密方法为加密的逆过程。
 * 数据范围：输入的两个字符串长度满足 1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
 *
 * 第一行输入一串要加密的密码
 * 第二行输入一串加过密的密码
 *
 * 第一行输出加密后的字符
 * 第二行输出解密后的字符
 * abcdefg
 * BCDEFGH
 *
 * BCDEFGH
 * abcdefg
 */
public class HJ29 {
    public static void main(String[] args) {
        String str ="adfg";
        System.out.println(str.charAt(2)+1);
    }
    /*public static String solution(String str){
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='a'&&ch[i]<='y'){
                sb.append(ch[i]+1)
            }
        }
    }*/
}