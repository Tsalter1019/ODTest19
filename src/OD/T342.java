package OD;

import java.util.Arrays;
import java.util.Scanner;

public class T342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int [] arr1;
        String a = sc.nextLine();
        arr1 = Arrays.stream(a.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] arr2 = new int[N-1][2];
        for(int i=0;i< arr2.length;i++){
            String b = sc.nextLine();
            arr2[i] = Arrays.stream(b.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sum=0;
        int max=0;
        int temp=0;
        for(int i=0;i<arr2.length;i++){
            if(arr2[i][0]!=temp){
                if(max<sum){
                    sum-=arr1[arr2[i-1][0]-1];
                    max = sum;
                    sum=0;
                }
            }
            temp = arr2[i][0];
            sum+=arr1[arr2[i][0]-1];
            sum+=arr1[arr2[i][1]-1];
        }
        if(arr2[arr2.length-1][0]==arr2[arr2.length-2][0]){
            if(max<sum){
                sum-=arr1[arr2[arr2.length-1][0]-1];
                max = sum;
            }
        }else{
            if(max<sum){
                max = sum;
            }
        }

        System.out.println(max);
    }
}
