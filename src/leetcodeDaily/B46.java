package leetcodeDaily;

import java.util.LinkedList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 2173 👎 0
public class B46 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list1.add(1);
        list1.add(3);
        list1.add(2);
        lists.add(list);
        lists.add(list1);
        System.out.println(lists);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> listT = new LinkedList<>();
        for(int i:nums){
            listT.add(i);
        }
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int i=0,j=nums.length;
        while(i<j){
            list.add(listT.get(i));

        }
        /*for(int i=0;i<nums.length;i++){

        }*/
        return lists;
    }
}