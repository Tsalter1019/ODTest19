package Deke;

import java.util.LinkedList;
import java.util.List;

/**输入一个字符串仅包含大小写字母和数字 求字符串中包含的最长的非严格递增连续数字序列长度
            比如：
                12234属于非严格递增数字序列
            示例：
            输入
                abc2234019A334bc
            输出
                4
            说明：
                2234为最长的非严格递增连续数字序列，所以长度为4
                aaaaaa44ko543j123j7345677781
                aaaaa34567778a44ko543j123j71
                345678a44ko543j123j7134567778aa
         */
public class A51 {
    public static void main(String[] args) {
        System.out.println(solution("aaaaa34567778a44ko543j123j71"));
    }
    public static int solution(String str){
        char[] ch = str.toCharArray();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                list.add(Integer.parseInt(ch[i]+""));
            }
        }
        int count=1;
        int max=0;
        int i=0;
        int j=list.size();
        while(i<j-1){
            if(list.get(i)<=list.get(i+1)){
                count++;
                i++;
            }else{
                if(max<count){
                    max = count;
                }
                i++;
                count=1;
            }
        }
        return max;
    }
}