package leetcode;
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
// 示例 1：
//输入：nums = [3,2,3]
//输出：3
// 示例 2：
//输入：nums = [2,2,1,1,1,2,2]
//输出：2


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class A169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(solution(nums));
    }
    public static int solution(int[] arr){

        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.keySet().contains(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for(int i :map.keySet()){
            if(arr.length%2==0){
                if(map.get(i)<(arr.length/2)){
                    map.remove(i);
                }
            }else{
                if(map.get(i)<(arr.length/2+1)){
                    map.remove(i);
                }
            }
        }
        int[] re = new int[map.size()];
        int index=0;
        for(int i:map.keySet()){
            re[index] = i;
            index++;
        }
        return re[0];
    }
}