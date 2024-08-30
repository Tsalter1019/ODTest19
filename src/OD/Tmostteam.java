package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tmostteam {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++){
            arr[i] = sc.nextInt();
        }
        int c = sc.nextInt();
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int count=0;
        for(int i=0;i<a;i++){
            list.add(arr[i]);
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=c){
                count++;
                list.remove(i);
                i--;
            }
        }
        int i=0,j=list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)>=c){
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
