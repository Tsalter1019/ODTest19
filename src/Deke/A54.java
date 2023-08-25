package Deke;

/**输入一个英文文章片段 翻转指定区间的单词顺序，标点符号和普通字母一样处理 例如输入字符串 "I am a developer." 区间[0,3]则输出 "developer. a am I"
     输入描述：
     使用换行隔开三个参数 第一个参数为英文文章内容即英文字符串 第二个参数为反转起始单词下标，下标从0开始 第三个参数为结束单词下标，
     输出描述
     反转后的英文文章片段，所有单词之间以一个半角空格分割进行输出
     示例一：
     输入
         I am a developer.
         1
         2
     输出
         I a am developer.
     示例二：
     输入
         Hello world!
         0
         1
     输出
         world! Hello

       说明：
       输入字符串可以在前面或者后面包含多余的空格，   但是反转后的不能包含多余空格
     示例三：
     输入：
         I am a developer.
         0
         3
     输出
         developer. a am I
       说明：
       如果两个单词见有多余的空格    将反转后单词间的空格减少到只含一个
      示例四：
      输入
       Hello!
       0
       3
      输出
       EMPTY
       说明：
       指定反转区间只有一个单词，或无有效单词则统一输出EMPTY
     */

public class A54 {
    public static void main(String[] args) {
        //String s = "I am    a      developer.";
        String s = "Hello world!";
        int begin = 0;
        int end = 3;
        System.out.println(solution(s,begin,end));
    }
    public static String solution(String s,int begin,int end){
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        String[] str = s.split("\\s+");
        if(end>str.length){
            return "EMPTY";
        }else{
            for(int i=end;i>=begin;i--){
                builder.append(str[i]).append(" ");
            }
            for(int i=0;i<str.length;i++){
                if(!(i>=begin-1||i<=end-1)){
                    builder1.append(str[i]);
                    builder1.append(" ");
                }else{
                    builder1.append(builder);
                    i = end;
                }
            }
            return builder1.substring(0,builder1.length()-1);
        }
    }
}