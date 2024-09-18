package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.List;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
//
// Related Topics 回溯 👍 1671 👎 0
public class B77 {
    public static void main(String[] args) {
        System.out.println(new B77().combine(4,2));
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }
    public void dfs(int cur,int n,int k){
        if(temp.size()+ (n-cur+1) < k){
            return ;
        }
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        dfs(cur+1,n,k);
        temp.remove(temp.size()-1);
        dfs(cur+1,n,k);
    }
}



