package nowcoder.OD108;


import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        StringBuffer sb = new StringBuffer();
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                sb.append(ch[i]);
            }else if((ch[i]+"").equals((ch[i]+"").toLowerCase())){
                if(ch[i]=='1'){
                    sb.append('1');
                }
                if(ch[i]=='a' || ch[i]=='b' || ch[i]=='c'){
                    sb.append('2');
                }
                if(ch[i]=='d' || ch[i]=='e' || ch[i]=='f'){
                    sb.append('3');
                }
                if(ch[i]=='g' || ch[i]=='h' || ch[i]=='i'){
                    sb.append('4');
                }
                if(ch[i]=='j' || ch[i]=='k' || ch[i]=='l'){
                    sb.append('5');
                }
                if(ch[i]=='m' || ch[i]=='n' || ch[i]=='o'){
                    sb.append('6');
                }
                if(ch[i]=='p' || ch[i]=='q' || ch[i]=='r' || ch[i]=='s'){
                    sb.append('7');
                }
                if(ch[i]=='t' || ch[i]=='u' || ch[i]=='v'){
                    sb.append('8');
                }
                if(ch[i]=='w' || ch[i]=='x' || ch[i]=='y' || ch[i]=='z'){
                    sb.append('9');
                }
                if(ch[i]=='0'){
                    sb.append('0');
                }
            }else{
                if(ch[i]=='Z'){
                    sb.append('a');
                }else{
                    sb.append(((char)(ch[i]+1)+"").toLowerCase());
                }
            }
        }
        System.out.println(sb.toString());
    }
}