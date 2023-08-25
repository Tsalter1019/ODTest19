package leetcode;


public class A20 {
    public static void main(String[] args) {
        System.out.println(new A20().isValid("{[()]}"));
    }
    public boolean isValid(String s) {
        if(s.contains("()")){
            int index = s.indexOf("()");
            String s1 = s.substring(0,index);
            String s2 = s.substring(index+2);
            String newS = s1+s2;
            if(newS.length()==0){
                return true;
            }else{
                return isValid(newS);
            }
        }
        else if(s.contains("[]")){
            int index = s.indexOf("[]");
            String s1 = s.substring(0,index);
            String s2 = s.substring(index+2);
            String newS = s1+s2;
            if(newS.length()==0){
                return true;
            }else{
                return isValid(newS);
            }
        }
        else if(s.contains("{}")){
            int index = s.indexOf("{}");
            String s1 = s.substring(0,index);
            String s2 = s.substring(index+2);
            String newS = s1+s2;
            if(newS.length()==0){
                return true;
            }else{
                return isValid(newS);
            }
        }else{
            return false;
        }
    }
}