package OD;

import java.util.*;

public class T352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[5];
        String[] strings = sc.nextLine().split("\\s+");
        for(int i=0;i<strings.length;i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        List<Integer> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap<>();
        for(int i=0;i<N;i++){
            int[] arr1 = new int[5];
            String aa = "";
            String[] strings1 = sc.nextLine().split("\\s+");
            for(int j=1;j<strings1.length;j++){
                aa+=strings1[j];
                aa+=" ";
            }
            map.put(strings1[0],aa.substring(0,aa.length()-1));
        }

        for(String a:map.keySet()){
            String [] re = map.get(a).split("\\s+");
//            int[] re1 = new int[re.length];
            int sum=0;
            for(int i=0;i<re.length;i++){
                sum += Integer.parseInt(re[i])*arr[i];
            }
            map1.put(a,sum);
            sum=0;
        }
        List<Map.Entry<String,Integer>> ll = new ArrayList<>(map1.entrySet());
        ll.sort((o1, o2) -> o2.getValue()-o1.getValue());
        for(int i=0;i<ll.size();i++){
            System.out.println(ll.get(i).getKey());
        }
    }
}
