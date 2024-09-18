package leetcodeDaily2024;

import java.util.*;
import java.util.stream.Collectors;

public class A2848 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        lists.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(9);
        lists.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(7);
        lists.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(10);
        lists.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(9);
        list4.add(10);
        lists.add(list4);
        System.out.println(new A2848().numberOfPoints(lists));
    }
    public int numberOfPoints(List<List<Integer>> nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            List<Integer> list = nums.get(i);
            int m = list.get(0);
            int n = list.get(1);
            for(int j=m;j<=n;j++){
                if(!map.containsKey(j)){
                    map.put(j,1);
                }
            }
        }
        return map.entrySet().size();
    }
}
