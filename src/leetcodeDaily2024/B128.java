package leetcodeDaily2024;

import java.util.TreeSet;

public class B128 {
    public static void main(String[] args) {
        int[] arr = {-8,-4,9,9,4,6,1,-4,-1,6,8};
        System.out.println(new B128().longestConsecutive(arr));
    }
    public int longestConsecutive(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(set.size()==0){
            return 0;
        }
        if(set.size()==1){
            return 1;
        }
        int count=1;
        int max = 1;
        for(int i=0;i<set.size();i++){
            if(i+1<=set.size()){
                int a = set.first();
                set.remove(a);
                i=0;
                if(set.first()==a+1){
                    count++;
                }else{
                    if(count>max){
                        max = count;
                    }
                    count=1;

                }
            }
        }
        if(count>max){
            max = count;
        }
        return max;
    }
}
