package leetcodeDaily2024;

public class A283 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        new A283().moveZeroes(arr);
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
