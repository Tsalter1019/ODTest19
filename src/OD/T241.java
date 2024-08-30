package OD;

import java.util.*;
import java.util.stream.Collectors;

public class T241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<String> list = new ArrayList<>();
        list.add(m+"="+m);
        int count=1;
        for(int i=1;i<m;i++){
            int sum = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=i;sum<m;j++){
                sum+=j;
                stringBuilder.append(j).append("+");
                if(sum==m){
                    list.add(m+"="+stringBuilder.substring(0,stringBuilder.length()-1));
                    count++;
                    break;
                }
            }
        }
//        list=list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        list.sort((o1,o2)->o1.length()-o2.length());

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("Result:"+count);
    }
}
