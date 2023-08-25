package leetcode;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 */
public class A1640 {
    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        //12  1
        System.out.println(new A1640().canFormArray(arr,pieces));
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        String A = "";
        for(int i=0;i<arr.length;i++){
            A+=arr[i];
        }
        String B = "";
        for(int i=0;i<pieces.length;i++){
            for(int j=0;j<pieces[i].length;j++){
                B+=pieces[i][j];
            }
        }
        if(B.length()!=A.length()){
            return false;
        }


        int count=0;
        for(int i=0;i<pieces.length;i++){
            String temp = "";
            for(int j=0;j<pieces[i].length;j++){
                temp+=pieces[i][j];
            }
            if(A.contains(temp)){
                count++;
            }
            temp = new String();
        }
        if(count==pieces.length){
            return true;
        }else{
            return false;
        }
    }
}