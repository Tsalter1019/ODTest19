package leetcodeDaily2024;

import java.util.*;

public class B18 {
    public static void main(String[] args) {
//        int[] arr = {1,0,-1,0,-2,2};
//        int[] arr = {2,2,2,2,2,2,2,2,2};
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(arr,-294967296));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        long[] arr = new long[cutUnused(nums).length];
        arr = cutUnused(nums);
        List<List<Integer>> resp = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    for(int l=k+1;l<arr.length;l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l] == target){
                            List<Integer> ans = new ArrayList<>();
                            ans.add((int) arr[i]);
                            ans.add((int) arr[j]);
                            ans.add((int) arr[k]);
                            ans.add((int) arr[l]);
                            Collections.sort(ans);
                            if(!resp.contains(ans)){
                                resp.add(ans);
                            }
                        }
                    }
                }
            }
        }
        return resp;
    }

    public static long[] cutUnused(int[] nums){
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            if(i.getValue()>4){
                i.setValue(4);
                list.add(i.getKey());
                list.add(i.getKey());
                list.add(i.getKey());
                list.add(i.getKey());
            }else{
                for(int j=0;j<i.getValue();j++){
                    list.add(i.getKey());
                }
            }
        }
        long[] arr = new long[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
