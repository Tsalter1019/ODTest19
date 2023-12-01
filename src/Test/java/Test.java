package Test.java;


public class Test {
    public int unequalTriplets(int[] nums) {
        int count=0;
        int l = nums.length;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                for(int k=j+1;k<l;k++){
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,4,2,4,3};
        String str = "中天aabbcccc";
        char[] ch = str.toCharArray();
        System.out.println(ch);

        //System.out.println(new Test().unequalTriplets(arr1));
    }
}