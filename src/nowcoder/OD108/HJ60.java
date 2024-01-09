package nowcoder.OD108;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=1;i<=a;i++){
            if(isPrimeOrNot(i) && isPrimeOrNot(a-i)){
                list.add(i+" "+(a-i));
            }
        }

        int min = a;
        int m=0;
        int n=0;


        for(int i=0;i<list.size();i++){
            String[] str = list.get(i).split(" ");
            int diff = Math.abs(Integer.parseInt(str[0])-Integer.parseInt(str[1]));
            if(diff<=min){
                min = diff;
            }
        }

        for(int i=0;i<list.size();i++){
            String[] str = list.get(i).split(" ");
            int diff = Math.abs(Integer.parseInt(str[0])-Integer.parseInt(str[1]));
            if(diff==min){
                m = Integer.parseInt(str[0]);
                n = Integer.parseInt(str[1]);
            }
        }
        if(m<=n){
            System.out.println(m);
            System.out.println(n);
        }else{
            System.out.println(n);
            System.out.println(m);
        }


    }

    private static boolean isPrimeOrNot(int x) {
        int j = 0;
        for (j = 2; j < Math.sqrt(x); j++) {
            if (x % j == 0) {
                break;
            }
        }
        if (j > Math.sqrt(x)) {
            return true;
        } else {
            return false;
        }
    }
}