package OD;

import java.util.*;

public class E003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));

    }
    public static String solution(String s){
        String [] strings = s.split("\\s+");
        strings = Arrays.stream(strings).map(a -> ss(a)).toArray(String[]::new);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            if(!map.containsKey(strings[i])){
                map.put(strings[i],1);
            }else{
                map.put(strings[i],map.get(strings[i])+1);
            }
        }
        Arrays.sort(strings,(o1,o2)->{
            if (map.get(o1)-map.get(o2)!=0){
                return map.get(o2) - map.get(o1);
            }else if(o1.length()!=o2.length()){
                return o1.length()-o2.length();
            }else{
                return o1.compareTo(o2);
            }
        });
        String res = "";
        for(String hh:strings){
            res+=hh;
            res+=" ";
        }
        return res.substring(0,res.length()-1);
    }
    public static String ss(String arr){
        String res="";
        char[] ch = arr.toCharArray();
        Arrays.sort(ch);
        for(char ch1:ch){
            res+=ch1;
        }
        return res;
    }
}
