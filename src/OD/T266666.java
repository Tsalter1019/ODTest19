package OD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T266666 {
    public static void main(String [] args){
        Scanner sc =  new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        for(int i=0;i<=9;i++){
            for(int j=0;j<list.size();j++){
                if((list.get(j)+"").endsWith(i+"")){
                    list1.add(list.get(j));
                    list.remove(j);
                    j--;
                }
            }
        }
        String a = "";
        for(int i=0;i<list1.size();i++){
            a = a+list1.get(i);
            a = a+",";
        }
        System.out.println(a.substring(0,a.length()-1));
    }
}
