package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Liulangdiqiu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[] arr = new int[n];
        Arrays.fill(arr,1001);
        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[b] = a;
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a  = Math.abs(i-j);
                int b = n-a;
                int m = Math.min(a,b);
                arr[j] = Math.min(arr[j],arr[i]+m);
            }
        }

        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = arr[i];
        }
        Arrays.sort(arr);
        int max = arr[n-1];
        int count=0;
        String res = "";
        for(int i=0;i<n;i++){
            if(arr1[i]==max){
                res+=i;
                res+=" ";
                count++;
            }
        }
        System.out.println(count);
        System.out.println(res.substring(0,res.length()-1));

    }
    public static List<Integer> toli(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        return list;
    }
}
