package OD.moni;

import java.util.Scanner;

public class Tlicai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split("\\s+");
        String[] str2 = sc.nextLine().split("\\s+");
        String[] str3 = sc.nextLine().split("\\s+");
        String[] str4 = sc.nextLine().split("\\s+");
        int a = Integer.parseInt(str1[0]);//产品数
        int b = Integer.parseInt(str1[1]);//总投资额
        int c = Integer.parseInt(str1[2]);//可接受风险
        int[] res = new int[a];
        int[] temp = new int[a];
        int[] arr2 = new int[str2.length];//回报率
        for(int i=0;i<str2.length;i++){
            arr2[i] = Integer.parseInt(str2[i]);
        }
        int[] arr3 = new int[str3.length];//风险值
        for(int i=0;i<str3.length;i++){
            arr3[i] = Integer.parseInt(str3[i]);
        }
        int[] arr4 = new int[str4.length];//可投额
        for(int i=0;i<str4.length;i++){
            arr4[i] = Integer.parseInt(str4[i]);
        }

        int max=0;
        for(int i=0;i<a;i++){

        }
    }
}
