package leetcodeDaily;


public class A2520 {
    public int countDigits(int num) {
        int count = 0;
        char[] ch = (num+"").toCharArray();
        for(int i=0;i<ch.length;i++){
            int m = Integer.parseInt(ch[i]+"");
            if(num%m==0){
                count++;
            }
        }
        return count;
    }
}