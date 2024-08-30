package OD;

import java.util.Arrays;
import java.util.Scanner;

public class T354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] strs = str1.split("\\s+");
        int[] arr = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        int b = sc.nextInt();
        System.out.println(solution(arr,b));
    }
    public static int solution(int[] arr,int b){
        if(b<arr.length){
            return 0;
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[arr.length-1];
        int speed = right;
        if(b==arr.length){
            return speed;
        }
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if(timeCount(arr,mid)<=b){
                speed = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return speed;
    }

    public static int timeCount(int[] arr,int speed){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=speed){
                count++;
            }else{
                if(arr[i]%speed==0){
                    count+=arr[i]/speed;
                }else{
                    count+=arr[i]/speed+1;
                }

            }
        }
        return count;
    }
}
