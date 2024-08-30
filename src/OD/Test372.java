package OD;

import java.util.Scanner;

public class Test372 {
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
        int max = 0;
        for(int i=0;i<arr4.length;i++){
            int sum;
            if(arr4[i]>b){
                sum=b;
            }else{
                sum=arr4[i];
            }

            if(sum>max&& sum<=b && arr3[i]<=c){
                if(arr4[i]>b){
                    temp[i]=b;
                }else{
                    temp[i] = arr4[i];
                }
                res = temp;
                max = sum;
                temp = new int[a];
            }
            for(int j=i+1;j<arr4.length;j++){
                if(arr4[i]+arr4[j]<=b && arr3[i]+arr3[j]<=c){
                    temp[i] = arr4[i];
                    temp[j] = arr4[j];
                    sum = arr4[i]+arr4[j];
                    if(sum>max){
                        res = temp;
                        max = sum;
                    }
                    temp = new int[a];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i< res.length;i++){
            stringBuilder.append(res[i]);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));

    }
}
