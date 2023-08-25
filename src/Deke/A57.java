package Deke;

import java.util.*;

/**给定一个字符串 只包含大写字母 求在包含同一字母的子串中 长度第K长的子串 相同字母只取最长的子串
     输入
     第一行 一个子串 1<len<=100 只包含大写字母 第二行为k的值
     输出
     输出连续出现次数第k多的字母的次数
     例子：
     输入
        AABAAA
        2
     输出
             1
       同一字母连续出现最多的A 3次
       第二多2次  但A出现连续3次

    输入
    AAAAHHHBBCDHHHH
    3
    输出
    2
    //如果子串中只包含同一字母的子串数小于k
    则输出-1
    */
public class A57 {
    public static void main(String[] args) {
        System.out.println(solution1("AAAAHHHBBCDHHHAAHDDCCC",3));
    }
    public static int solution1(String str,int n){
        int count=1;
        int max =1;

        Map<Character,Integer> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();
        int i=0,j=str.length()-1;
        while (i+1<=j){
            if(str.charAt(i+1)==str.charAt(i)){
                count++;
                i++;
            }else{
                if(map.size()==0){
                    map.put(str.charAt(i),count);
                    count=1;
                    i++;
                }else{
                    if(map.containsKey(str.charAt(i))){
                        int a = map.get(str.charAt(i));
                        map.put(str.charAt(i),Math.max(count,a));
                        count=1;
                        i++;
                    }else{
                        map.put(str.charAt(i),count);
                        count=1;
                        i++;
                    }
                }
            }
            if(i==str.length()-1){
                map.put(str.charAt(i),count);
            }
        }
        for(Character c:map.keySet()){
            list.add(map.get(c));
        }

        Collections.sort(list);
        Collections.reverse(list);
        if(n>list.size()){
            return -1;
        }else{
            return list.get(n-1);
        }
    }
    public static int solution(String str,int n){
        int count=1;

        Map<Character, Integer> map = new LinkedHashMap<>();
        //修改TreeMap排序方式按降序排---按key排
//        Comparator<Character> keyComparator = new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return o2.compareTo(o1);
//            }
//        };
//        Map<Character,Integer> map = new TreeMap<Character,Integer>(keyComparator);

        List<Integer> list = new LinkedList<>();

        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }else{
                    map.put(str.charAt(i),count);
                    i = j-1;
                    count=1;
                    break;
                }
                if(j==str.length()-1){
                    map.put(str.charAt(i),count);
                    i = j-1;
                    break;
                }
            }
        }

//        根据value降序排序map内的键值对
//        map.entrySet().stream().sorted((o1,o2) ->
//                o2.getValue().compareTo(o1.getValue()))
//                .forEach(entry -> map.put(entry.getKey(),entry.getValue()));


        for(Character c:map.keySet()){
            list.add(map.get(c));
        }

        Collections.sort(list);
        Collections.reverse(list);
        if(n>list.size()){
            return -1;
        }else{
            return list.get(n-1);
        }

    }
}
