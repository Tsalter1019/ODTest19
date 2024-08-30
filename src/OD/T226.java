package OD;
import java.util.*;
public class  T226{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++){
            arr[i] = sc.nextInt();
        }
        int c = sc.nextInt();
        Arrays.sort(arr);

        int count=0;

        for(int i=0;i< arr.length;i++){
            if(arr[i]>=c){
                count++;
            }
        }
        int[] arr1 = new int[a-count];
        for(int i=0;i< arr.length;i++){
            if(arr[i]<c){
                arr1[i] = arr[i];
            }
        }
        int i=0,j=arr1.length-1;
        while(i<j){
            if(arr1[i]+arr1[j]>=c){
                count++;
                i++;
                j--;
            }else{
                i++;
            }
        }
        System.out.println(count);
    }
}