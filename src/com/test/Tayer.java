package com.test;


import java.util.*;

public class Tayer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        System.out.println(firstPalindrome(str));

    }

    //public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //
    //}

    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(isHuiwen(words[i])){
                return words[i];
            }
        }
        return "";
    }
    public static boolean isHuiwen(String s){
        if(new StringBuilder(s).reverse().toString().equals(s)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb = new StringBuffer();
        for(String s : word1){
            sb.append(s);
        }
        String str = sb.toString();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<word2.length;i++){
            sbf.append(word2[i]);
        }
        if(str.equals(sbf.toString())){
            return true;
        }else{
            return false;
        }

    }

    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int [] ans = new int[2*length];
        Arrays.copyOf(nums,2*nums.length);
        System.out.println(nums);
        return null;
    }
    public static int removeDuplicates(Integer[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        return 0;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int[] nums = new int[candies.length];
        int max=0;
        for(int i=0;i<candies.length;i++){
            nums[i]=candies[i]+extraCandies;
            max = Math.max(max,candies[i]);
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]>=max){
                list.add(true);
            }else {
                list.add(false);
            }
        }
        return list;
    }
    public static String interpret(String command) {
        char[] ch = command.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='G'){
                builder.append('G');
            }
            if(ch[i]=='('&&ch[i+1]==')'){
                builder.append('o');
            }
            if(ch[i]=='('&&ch[i+1]=='a'&&ch[i+2]=='l'&&ch[i+3]==')'){
                builder.append("al");
            }
        }
        return builder.toString();
    }
    //public String longestCommonPrefix(String[] strs) {
    //
    //    for(int i=0;i<strs.length;i++){
    //        strs[i]
    //    }
    //}

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }