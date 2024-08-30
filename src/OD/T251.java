package OD;

import java.util.*;

public class T251 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int a = sc.nextInt();
        System.out.println(solution(str,a));
    }
    public static int solution(String str,int a){

        Map<Character,Integer> map = new TreeMap<>();
        int len = str.length();
        int count=0;
        for(int i=0;i<len;i++){
            if(i+1 <len&& str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                map.put(str.charAt(i),count+1);
                count=0;
            }
        }


        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1,o2) ->o2.getValue()-o1.getValue());

        if(a>list.size() || a<=0){
            return -1;
        }
        return list.get(a-1).getValue();
    }
}
