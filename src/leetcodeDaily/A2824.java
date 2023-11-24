package leetcodeDaily;


import java.util.ArrayList;
import java.util.List;

public class A2824 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        int tar = 2;
        System.out.println(new A2824().countPairs(list,tar));
    }
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i)+nums.get(j)<target){
                    count++;
                }
            }
        }
        return count;
    }
}