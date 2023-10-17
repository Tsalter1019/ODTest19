package leetcodeDaily;


import java.util.Arrays;

public class A0102 {
    public static void main(String[] args) {
        System.out.println(new A0102().CheckPermutation("abecd","ecdab"));
    }
    public boolean CheckPermutation(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        String newS1 = "";
        String newS2 = "";
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<ch1.length;i++){
            newS1+=ch1[i];
        }
        for(int i=0;i<ch2.length;i++){
            newS2+=ch2[i];
        }
        if(ch1.length!=ch2.length){
            return false;
        }else{
            if(newS1.equals(newS2)){
                return true;
            }else{
                return false;
            }
        }
    }
}