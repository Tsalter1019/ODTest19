package Test.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //System.out.println(isStrEquOrNot("高层住宅,多层住宅,装饰","多层住宅,高层住宅,装饰"));
        solution();
    }
    //        Object[] obj = {"高层住宅,多层住宅","装饰","2"};
    //        Object[] obj1 = {"多层住宅","主体","1"};
    //        Object[] obj2 = {"多层住宅,高层住宅","主体","1"};
    public static void solution(){
        Object[] obj = {"高层住宅,多层住宅","装饰",1};
        Object[] obj1 = {"多层住宅","主体",1};
        Object[] obj2 = {"多层住宅,高层住宅","主体",1};
        Object[] obj3 = {"多层住宅,高层住宅","装饰",1};

        ArrayList<Object []> list = new ArrayList<>();
        list.add(obj);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        String[] str1 = new String[list.size()];
        String[] str2 = new String[list.size()];
        String[] str3 = new String[list.size()];

        int[] int3 = new int[list.size()];
        for(int i=0;i<list.size();i++){
            str1[i] = list.get(i)[0].toString();
            str2[i] = list.get(i)[1].toString();
            int3[i] = (int) list.get(i)[2];
        }
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap<>();

        for(int i=0;i<list.size();i++){
            str3[i] = str1[i]+","+str2[i];
            map.put(str3[i],int3[i]);
        }

        for(String s:map.keySet()){
            if(!map1.containsKey(s) && isMapContainsKey(s,map1)){
                map1.put(s,map.get(s));
            }
        }



        System.out.println(11);

    }

    private static boolean isMapContainsKey(String str,Map<String,Integer> map){
        int count=0;
        String[] arr1 = new String[map.size()];
        String[] arr2 = new String[map.size()];
        int i=0;
        for(String s : map.keySet()){
            arr1[i] = s;
            String [] arr = str.split(",");
            Arrays.sort(arr);
            String newS = coop(arr);
            arr2[i] = newS;
            i++;
        }
        return true;
    }

    public static String coop(String[] arr){
        String res = "";
        for(int i =0;i<arr.length;i++){
            res=res+arr[i]+",";
        }
        return res.substring(0,res.length()-1);
    }
}