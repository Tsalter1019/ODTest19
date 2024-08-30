package leetcodeDaily;

import java.util.*;

//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
// 示例 1 ：
//输入：nums = [2,2,1]
//输出：1
// 示例 2 ：
//输入：nums = [4,1,2,1,2]
//输出：4
// 示例 3 ：
//输入：nums = [1]
//输出：1
// 提示：
// 1 <= nums.length <= 3 * 10⁴
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴
// 除了某个元素只出现一次以外，其余每个元素均出现两次。
// Related Topics 位运算 数组 👍 2858 👎 0
public class A136 {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(new A136().singleNumber1(arr));
    }
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        if(list.size()==0){
            return 0;
        }else{
            return list.get(0);
        }

    }
}
