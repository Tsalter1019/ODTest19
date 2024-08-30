package leetcodeDaily2024;

public class A392 {
    public boolean isSubsequence(String s, String t) {
        int m=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=m;j<t.length();j++){
                m++;
                if(t.charAt(j)==s.charAt(i)){
                    count++;
                    break;
                }
            }
        }
        if(count==s.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new A392().isSubsequence("acb","ahbgdc"));
    }
}
