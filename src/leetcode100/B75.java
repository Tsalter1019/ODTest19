package leetcode100;

public class B75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        for(int i=0;i<= right;i++){
            if(nums[i]==0){
                swap(i,left,nums);
                left++;
            }else if(nums[i]==2){
                swap(right,i,nums);
                right--;
                i--;
            }
        }
    }
    public static void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new B75().sortColors(arr);
    }

}
