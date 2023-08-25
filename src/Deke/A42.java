package Deke;

import java.util.*;

/**是一种为局域网设备进行逻辑划分的技术 为了标识不同的 引入了 id 1~4094之间的整数 定义一个 id 的资源池 资源池中连续的用开始
-结束表示， 不连续的用单个整数表示 所有的用英文逗号连接起来 现有一个资源池，业务需要从资源池中申请一个需要你输出从资源池
中移除申请的后的资源池

    输入描述
    第一行为字符串格式的资源池
    第二行为业务要申请的 的取值范围1~4094

    输出描述
从输入资源池中移除申请的后字符串格式的资源池 输出要求满足题目中要求的格式，
 并且要求从小到大升序输出如果申请的不在原资源池输出升序排序的原资源池的字符串即可

    示例一
    输入
    1-5
    2
    输出
    1,3-5
    说明：原资源池中有1 2 3 4 5 移除2后 剩下的1 3 4 5按照升序排列的方式为 1 3-5

    示例二
    输入
    20-21,15,18,30,5-10
    15
    输出
    5-10,18,20-21,30
    说明：
原资源池中有5 6 7 8 9 10 15 18 20 21 30   移除15后 剩下的为 5 6 7 8 9 10 18 20 21 30 按照题目描述格式并升序后的结果为5-10,18,20-21,30
    示例三
    输入
    5,1-3
    10
    输出
    1-3,5
    资源池中有1 2 3 5 申请的资源不在资源池中 将原池升序输出为1-3,5
    输入池中数量范围为2~2094的整数 资源池中不重复且合法1~2094的整数 输入是乱序的 */
public class A42 {
    public static void main(String[] args) {
        String s = "20-21,15,18,30,5-10";
        //String s = "1-5";
        //String s = "5,1-3";
        //String s = "1-7,8-10";
        //List<String> list = new LinkedList<>();
        //list.add("20")
        int m=7;
        System.out.println(solution(s,m));
    }
    public static String solution1(String s,int m){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new LinkedList<>();
        String[] str = s.split(",");
        for(String a:str){
            list.add(a);
        }
        for(int i=0;i<list.size();i++){
            String[] ss = list.get(i).split("-");
            int former = Integer.parseInt(ss[0]);
            if(ss.length==1){
                if(former==m){
                    list.remove(i);
                    break;
                }
            }else{
                int latter = Integer.parseInt(ss[1]);
                if(m>=former&&m<=latter){

                }
            }
        }
        return null;
    }
    public static String solution(String s,int m){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new LinkedList<>();
        String[] str = s.split(",");
        for(String a:str){
            list.add(a);
        }
        for(int i=0;i<list.size();i++){
            String t = list.get(i);
            String[] ss = t.split("-");
            if(ss.length>1){
                if(Integer.parseInt(ss[0])<=m&&m<=Integer.parseInt(ss[1])){
                    int a = Integer.parseInt(ss[0]);//第一位
                    int b = Integer.parseInt(ss[1]);//最后一位
                    if(m<b-1&&m>a+1){
                        if(b<m){
                            continue;
                        }else if(b==m){
                            list.remove(i);
                            list.add(a+"-"+(m-1));
                            break;
                        }else{
                            list.remove(i);
                            list.add(a+"-"+(m-1));
                            list.add((m+1)+"-"+b);
                            break;
                        }
                    }
                    if(b==m){
                        list.remove(i);
                        list.add(a+"-"+(m-1));
                        break;
                    }
                    if(a==m){
                        list.remove(i);
                        list.add(a+1+"-"+b);
                        break;
                    }
                    if(m==a+1){
                        list.remove(i);
                        list.add(a+"");
                        list.add(m+1+"-"+b);
                        break;
                    }
                    if(m==b-1){
                        list.remove(i);
                        list.add(a+"-"+(m-1));
                        list.add(b+"");
                        break;
                    }
                }
            }else{
                list.remove(i);
                break;
            }
        }

        Map<Integer,String> map = new HashMap<>();
        List<Integer> list1 = new LinkedList<>();
        for(int i=0;i<list.size();i++){
            map.put(Integer.parseInt(list.get(i).split("-")[0]),list.get(i));
        }
        for(int i:map.keySet()){
            list1.add(i);
        }

        Collections.sort(list1);

        for(int i=0;i<map.size();i++){
            stringBuilder.append(map.get(list1.get(i)));
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}