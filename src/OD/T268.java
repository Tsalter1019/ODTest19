package OD;
import java.util.Arrays;
import java.util.Scanner;

public class T268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        char[] min = s.toCharArray();
        Arrays.sort(min);

        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=min[i]){
                char temp  = ch[i];
                ch[i] = min[i];

                int index = s.lastIndexOf(min[i]);
                ch[index] = temp;
                break;
            }
        }
        String res = "";
        for(int i=0;i<ch.length;i++){
            res+=ch[i];
        }
        return res;
    }
}