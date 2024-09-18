package leetcodeDaily2024;

import java.util.Arrays;

public class A455 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {3};
        System.out.println(new A455().findContentChildren(g,s));
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int index = s.length-1;
        boolean[] bite = new boolean[g.length];
        for(int i=g.length-1;i>=0;i--){
            while(index >=0&& s[index]>=g[i] && !bite[i]){
                count++;
                index--;
                bite[i] = true;
            }
        }
        return count;
    }
}
