package nowcoder.OD108;

import java.util.Scanner;

/**
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 密码里的字母全都是小（大）写字母
 * 20 分: 密码里的字母符合”大小写混合“
 *
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 *
 * 五、奖励（只能选符合最多的那一种奖励）:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱（Very_Weak）
 *
 * 对应输出为：
 *
 * VERY_SECURE
 * SECURE
 * VERY_STRONG
 * STRONG
 * AVERAGE
 * WEAK
 * VERY_WEAK
 */
public class HJ87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            int score = 0;
            if(str.length()<=4){
                score+=5;
            }else if(str.length()>=5 && str.length()<=7){
                score+=10;
            }else{
                score+=25;
            }

            if(!isContainLetter(str)){
                score+=0;
            }else if(str.equals(str.toLowerCase())){
                score+=10;
            }else if(LowAndUpp(str)){
                score+=20;
            }

            score+=ditCount(str);
            score+=symbolCount(str);
            score+=bonusScore(str);

            if(score>=90){
                System.out.println("VERY_SECURE");
            }else if(score>=80 && score<90){
                System.out.println("SECURE");
            }else if(score>=70 && score<80){
                System.out.println("VERY_STRONG");
            }else if(score>=60 && score<70){
                System.out.println("STRONG");
            }else if(score>=50 && score<60){
                System.out.println("AVERAGE");
            }else if(score>=25 && score<50){
                System.out.println("WEAK");
            }else if(score>=0 && score<25){
                System.out.println("VERY_WEAK");
            }

        }
    }

    public static int bonusScore(String str){
        if(ditCount(str)!=0 && symbolCount(str)!=0 && LowAndUpp(str)){
            return 5;
        }else if(isContainLetter(str) && ditCount(str)!=0 && symbolCount(str)!=0){
            return 3;
        }else if(isContainLetter(str) && ditCount(str)!=0){
            return 2;
        }


        return 0;
    }

    public static boolean isContainLetter(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isLetter(ch[i])){
                count++;
            }
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isUpp(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isUpperCase(ch[i])){
                count++;
            }
        }
        if(count==str.length()){
            return true;
        }else{
            return false;
        }

    }
    public static boolean isLow(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isLowerCase(ch[i])){
                count++;
            }
        }
        if(count==str.length()){
            return true;
        }else{
            return false;
        }

    }
    public static boolean LowAndUpp(String str){
        int count=0;
        int count1=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isLowerCase(ch[i])){
                count++;
            }
            if(Character.isUpperCase(ch[i])){
                count1++;
            }
        }
        if(count>0 && count1>0){
            return true;
        }else{
            return false;
        }
    }


    public static int ditCount(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                count++;
            }
        }
        if(count==0){
            return 0;
        }else if(count==1){
            return 10;
        }else{
            return 20;
        }

    }

    public static int  symbolCount(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(!Character.isDigit(ch[i]) && !Character.isLetter(ch[i])){
                count++;
            }
        }

        if(count==0){
            return 0;
        }else if(count==1){
            return 10;
        }else{
            return 25;
        }
    }
}