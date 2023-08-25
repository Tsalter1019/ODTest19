package Deke;

/**
    有一种简易压缩算法：针对全部为小写英文字母组成的字符串， 将其中连续超过两个相同字母的部分压缩为连续个数加该字母 其他部分保持原样不变.
    例如字符串aaabbccccd  经过压缩变成字符串 3abb4cd 请您编写解压函数,根据输入的字符串, 判断其是否为合法压缩过的字符串 若输入合法则输出
    解压缩后的字符串 否则输出字符串"!error"来报告错误
    输入描述
      输入一行，为一个ASCII字符串 长度不超过100字符 用例保证输出的字符串长度也不会超过100字符串
    输出描述
      若判断输入为合法的经过压缩后的字符串 则输出压缩前的字符串 若输入不合法 则输出字符串"!error"
     示例一：
      输入
       4dff
      输出
       ddddff
      说明
        4d扩展为4个d ，故解压后的字符串为ddddff
     示例二
       输入
         2dff
       输出
         !error
        说明
         2个d不需要压缩 故输入不合法
      示例三
       输入
        4d@A
       输出
        !error
        说明
         全部由小写英文字母做成的字符串，压缩后不会出现特殊字符@和大写字母A 故输入不合法
     */
public class A62 {
    public static void main(String[] args) {
        //10
        System.out.println(solution("2dff"));
    }

    public static String solution(String str){
        StringBuilder stringBuilder = new StringBuilder();

        char[] ch = str.toCharArray();
        int num=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='a'&&ch[i]<='z'){
                stringBuilder.append(ch[i]);
                continue;
            }
            if(ch[i]<='2'&&!(ch[i+1]>='0'&&ch[i+1]<='9')){
                return "!error";
            }

            if((ch[i]>='3'&&ch[i]<='9')&&(ch[i+1]>='a'&&ch[i+1]<='z')){
                num = Integer.parseInt(ch[i]+"");
                for(int m=0;m<num;m++){
                    stringBuilder.append(ch[i+1]);
                }
                i = i+1;
                continue;
            }
            if((ch[i]>='1'&&ch[i]<='9')&&(ch[i+1]>='0'&&ch[i+1]<='9')){
                num= Integer.parseInt((ch[i]+"")+(ch[i+1]+""));
                for(int m=0;m<num;m++){
                    stringBuilder.append(ch[i+2]);
                }
                i = i+2;
                continue;
            }
            if(!(ch[i]>='a'&&ch[i]<='z')){
                return "!error";
            }

        }
        return stringBuilder.toString();
    }

/*    public static String solution(String str){
        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = str.toCharArray();
        int count=1;
        for(int i=0;i<ch.length;i++){
            for(int j=i+1;j<ch.length;j++){
                    if(ch[i]==ch[j]){
                        count++;
                    }else{
                        if(count>2){
                            stringBuilder.append(ch[i]).append(count);

                        }else{
                            if(count==1){
                                stringBuilder.append(ch[i]);
                            }
                            if(count==2){
                                stringBuilder.append(ch[i]);
                                stringBuilder.append(ch[i]);
                            }
                        }
                        i = j;
                        count=1;

                    }
                }
               *//* if(i==ch.length-1){
                    stringBuilder.append(ch[ch.length-1]);
                }*//*
            }

        return stringBuilder.toString();
    }*/
}