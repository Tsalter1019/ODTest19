package OD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class T340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String stack = "";
        int count=1;
        int max=0;
        String sss="";
        for(int i=0;i<str.length();i++){

            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                stack+=str.charAt(i);
            }else if(!stack.endsWith("+")||!stack.endsWith("-")||!stack.endsWith("*")){
                if(str.charAt(i) == '+' || str.charAt(i) == '-' ||str.charAt(i)=='*'){
                    stack+=str.charAt(i);
                    count++;
                }else{
                    if(count>max){
                        max = count;
                        sss = stack;
                    }
                    stack = new String();
                    count=1;
                }
            }

        }
        if(count>max){
            max = count;
            sss = stack;
            stack = new String();
            count=1;
        }
        if(sss.endsWith("+")||sss.endsWith("-")||sss.endsWith("*")||sss.length()==0||(!sss.contains("+")&&!sss.contains("-")&&!sss.contains("*"))){
            System.out.println("0");
            return;
        }
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for(int i=0;i<sss.length();i++){
            String[] re = sss.split("\\+");
            for(int j=0;j< re.length;j++){
                list1.add(re[j]);
                list1.add("+");
            }
            break;
        }
        list1.remove(list1.size()-1);
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).contains("-")){
                String[] re = list1.get(i).split("\\-");
                for(int j=0;j<re.length;j++){
                    list.add(re[j]);
                    list.add("-");
                }
            }else{
                list.add(list1.get(i));
            }
        }
        if(list.get(list.size()-1)=="-"){
            list.remove(list.size()-1);
        }
        String stack1 = new String();
        int sum=0;//1-2sdsdds2+7*7-8*2
        for(int i=0;i<list.size();i++){
            if(list.get(i).contains("*")){
                int ss = 0;
                String[] ars = list.get(i).split("\\*");
                ss = Integer.parseInt(ars[0]) * Integer.parseInt(ars[1]);
                stack1+=ss;
            }else{
                stack1+=list.get(i);
            }
        }
        String [] strings = stack1.split("\\+");
        for(int i=0;i<strings.length;i++){
            if(!strings[i].contains("-")){
                sum+=Integer.parseInt(strings[i]);
            }else{
                String[] bb = strings[i].split("\\-");
                sum+=Integer.parseInt(bb[0])-Integer.parseInt(bb[1]);
            }
        }
        System.out.println(sum);
    }

}
