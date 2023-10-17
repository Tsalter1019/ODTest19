package leetcodeDaily;


//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
// 整数 a 比整数 b 更接近 x 需要满足：
// |a - x| < |b - x| 或者
// |a - x| == |b - x| 且 a < b
// 示例 1：
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 示例 2：
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 提示：
// 1 <= k <= arr.length
// 1 <= arr.length <= 10⁴
// arr 按 升序 排列
// -10⁴ <= arr[i], x <= 10⁴


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class B658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        int[] arrs = new int[arr.length+1];
        for(int i=0;i<arrs.length-1;i++){
            arrs[i] = arr[i];
        }
        if(x<=arr[0]){
            for(int i=0;i<k;i++){
                list.add(arr[i]);
            }
        }else if(x>=arr[arr.length-1]){
            for(int i=arr.length-1;i>=arr.length-k;i++){
                list.add(arr[i]);
            }
        }else if(x>arr[0]&&x<arr[arr.length-1]){
            arrs[arrs.length-1] = x;
            Arrays.sort(arrs);

        }
        return null;
    }
}
