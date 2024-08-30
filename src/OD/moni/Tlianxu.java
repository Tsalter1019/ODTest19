package OD.moni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tlianxu {//数字拆分成连续数字累加
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        List<String> list = new ArrayList<>();
        int sum=0;
        int count=1;
        System.out.println(m+"="+m);
        StringBuilder s = new StringBuilder();
        for(int i=1;i<m;i++){
            for(int j=i;sum<m;j++){
                sum+=j;
                s.append(j);
                s.append("+");
                if(sum==m){
                    list.add(m+"="+s.substring(0,s.length()-1));
                    count++;
                }
            }
            sum=0;
            s = new StringBuilder();
        }
        list.sort((o1,o2)->o1.split("\\+").length-o2.split("\\+").length);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("Result:"+count);

    }
}
