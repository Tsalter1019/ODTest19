package OD;

import java.util.HashMap;
import java.util.Scanner;

public class T397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split("\\s+");
        int[] arr = new int[str.length];
        for(int i=0;i<arr.length;i++){//x个小朋友反馈有y人和自己同小区   y是key  x是value
            arr[i] = Integer.parseInt(str[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        int sum=0;
        for(Integer i: map.keySet()){//ceil(x/y+1)*(y+1)
            sum+=Math.ceil(map.get(i)*1.0/(i+1))*(i+1);
        }
        System.out.println(sum);
    }
}
