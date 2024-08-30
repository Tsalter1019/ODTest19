package leetcode100;

import java.util.HashSet;
import java.util.Set;

public class B3 {
    public static void main(String[] args) {
//        String a="abcabcbb";
//        String a="au";
//        String a="dvdf";
//        String a="dd";
        String a="";
        System.out.println(new B3().lengthOfLongestSubstring(a));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0,r = l+1;
        int max =0;
        if(s.length()<=1){
            return s.length();
        }
        String str=s.charAt(l)+"";
        for(int i=l;i<n;i++){
            if(r<n && !str.contains(s.charAt(r)+"")){
                str+=s.charAt(r);
                r++;
            }else{
                if(max<str.length()){
                    max = str.length();
                }
                l++;
                r=l+1;
                str = s.charAt(l)+"";
                i=l;
            }
        }
        if(max<str.length()){
            max = str.length();
        }
        return max;
    }
}
