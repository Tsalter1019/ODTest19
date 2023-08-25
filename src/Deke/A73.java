package Deke;

import java.util.*;

/**
    给出一个只包含字母的字符串,
    不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
    并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
    如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
    输入描述:
      输入一行仅包含字母的字符串
    输出描述:
      按照字母出现次数从大到小的顺序输出各个字母和字母次数,
      用英文分号分割,
      注意末尾的分号
      字母和次数中间用英文冒号分隔
    示例:
        输入: xyxyXX
        输出:x:2;y:2;X:2;
    说明:每个字符出现的次数为2 故x排在y之前
    而小写字母x在大写X之前

    示例2:
        输入:
         abababb
        输出:
            b:4;a:3
        说明:b的出现个数比a多 故排在a前
     */
public class A73 {
    public static void main(String[] args) {
        solution("xyxyXX");
    }
    public static void solution(String str){
        StringBuilder stringBuilder = new StringBuilder();
        //abababb
        char[] ch = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for(int i=0;i<ch.length;i++){
            set.add(ch[i]);
        }
        List<Character> list = new ArrayList(set);

        int len = ch.length;
        int count=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<len;j++){
                if(list.get(i)==ch[j]){
                    count++;
                }
            }
            map.put(list.get(i),count);
            count=0;
        }
        for(int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i));
            stringBuilder.append(":");
            stringBuilder.append(map.get(list.get(i)));
            stringBuilder.append(";");
        }
        System.out.println(stringBuilder.toString());
    }
}