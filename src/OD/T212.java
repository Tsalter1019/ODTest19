package OD;

import java.util.*;

public class T212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split("\\s+");
        int[] arr= new int[strings.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int res=0;
        List<Integer> list1 = new ArrayList<>();

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1,o2)->o2.getValue()-o1.getValue());
        int max = list.get(0).getValue();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getValue().equals(max)){
                list1.add(list.get(i).getKey());
            }
        }
        Collections.sort(list1);
        int m = list1.size();

        if(m%2==0){
            res = (list1.get(m/2-1)+list1.get(m/2))/2;
        }else{
            res = list1.get(m/2);
        }
        System.out.println(res);
    }
}
