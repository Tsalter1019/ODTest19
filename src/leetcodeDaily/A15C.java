package leetcodeDaily;

import java.util.Arrays;

public class A15C {
    public static void main(String[] args) {
        int[] arr= {5, 7, 1, 2, 8, 4, 3};
        int target = 10;
        System.out.println(solution(arr,target));
    }
    public static boolean solution(int[] arr,int target){
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int l=i+1,r=n-1;
            while(l<r){
                int sum = arr[l]+arr[r];
                if(sum==(target-arr[i])){
                    l++;
                    while(l<r && arr[l]==arr[l-1]) l++;
                    r--;
                    while(l<r && arr[r]==arr[r+1]) r--;
                    return true;
                }else if(sum<(target-arr[i])){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return false;
    }
}
