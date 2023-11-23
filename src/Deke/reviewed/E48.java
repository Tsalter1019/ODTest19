package Deke.reviewed;

/** 给定一个元素类型为小写字符串的数组 请计算两个没有相同字符的元素长度乘积的最大值 如果没有符合条件的两个元素返回0
        输入描述
          输入为一个半角逗号分割的小写字符串数组
          2<= 数组长度 <=100
          0< 字符串长度 <=50
        输出描述
          两个没有相同字符的元素长度乘积的最大值

        示例一
          输入
            iwdvpbn,hk,iuop,iikd,kadgpf
          输出
            14
          说明
           数组中有5个元组  第一个和第二个元素没有相同字符
           满足条件 输出7*2=14
         */
public class E48 {
    public static void main(String[] args) {
        String[] str = {"iwdvpbn","hk","iuop","iikd","kadgpf"};
        System.out.println(solution(str));
    }
    public static int solution(String[] str){
        int max =0;
        int multiply=0;
        for(int i=0;i<str.length;i++){
            for(int j=i+1;j<str.length;j++){
                if(hasIdenticalCharacter(str[i],str[j])){
                    multiply = str[i].length()*str[j].length();
                    if(max<multiply){
                        max = multiply;
                    }
                }
            }
        }
        return max;
    }
    public static boolean hasIdenticalCharacter(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        for(int i=0;i<ch1.length;i++){
                if(str2.contains(ch1[i]+"")){
                    return false;
                }
        }
        return true;
    }
}