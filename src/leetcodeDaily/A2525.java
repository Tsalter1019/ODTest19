package leetcodeDaily;


import java.math.BigInteger;

public class A2525 {
    public static void main(String[] args) {
        System.out.println(new A2525().categorizeBox(10000,1,1,1));
    }
    public String categorizeBox(int length, int width, int height, int mass) {
        StringBuffer res = new StringBuffer();
        long tiji = length*width*(long)height;
        int shisi = (int) Math.pow(10,4);
        int shijiu = (int) Math.pow(10,9);
        if(length>=shisi||width>=shisi||height>=shisi||(length>=shisi&&width>=shisi)||(length>=shisi&&height>=shisi)||(width>shisi&&height>=shisi)||tiji>=shijiu){
            res.append("Bulky");
        }
        if(mass>=100){
            res.append("Heavy");
        }
        if(res.toString().contains("Bulky")&&res.toString().contains("Heavy")){
            return "Both";
        }else if((!res.toString().contains("Bulky"))&&(!res.toString().contains("Heavy"))){
            return "Neither";
        }
        return res.toString();
    }
}