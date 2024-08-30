package OD;

import java.util.Scanner;

public class T006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("\\s+");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int i = a;
        int count=0;
        while(i<=b){
            if(!Integer.toBinaryString(i).contains("101")){
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}
