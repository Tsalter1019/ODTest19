package Deke;

import java.util.*;

/********************************单词接龙*******************************
 * 的规则是 用于接龙的单词首字母必须要与前一个单词的尾字母相同 当存在多个首字母相同的单词时 取长度最长的单词 如果长度也相等则取词典序最小的单词
 已经参与接龙的单词不能重复使用 现给定一组全部由小写字母组成的单词数组 并指定其中的一个单词为起始单词 进行单词接龙 请输出最长的单词串 单词串是由单词拼接而成 中间没有空格
        输入描述：
            输入的第一行为一个非负整数 表示起始单词在数组中的索引k  0<=k<=n
            第二行输入的是一个非负整数表示单词的个数n 接下来的n行分别表示单词数组中的单词
        输出描述：
            输出一个字符串表示最终拼接的字符串
        示例1：
        输入
          0
          6
          word
          dd
          da
          dc
          dword
          d
        输出
          worddwordda

        说明：
        先确定起始单词word 再确定d开头长度最长的单词dword 剩余以d开头且长度最长的由 da dd dc 则取字典序最小的da
        所以最后输出worddwordda
        示例二：
        输入：
            4
            6
            word
            dd
            da
            dc
            dword
            d
         输出：
         dwordda

     */

public class A55 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int begin = Integer.parseInt(sc.nextLine());
        int length = Integer.parseInt(sc.nextLine());
        String[] strs = new String[length];
        for(int i=0;i<strs.length;i++){
            strs[i] = sc.nextLine();
        }*/
        int begin = 4;
        String[] strs = {"word","dd","da","dc","dword","d"};
        System.out.println(solution(begin,strs));
    }
    public static String solution(int m,String[] arr){
        List<String> list = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        StringBuilder builder = new StringBuilder();
        char last = arr[m].charAt(arr[m].length()-1);
        builder.append(arr[m]);
        list.remove(m);

        while(list.size()>0&&pan(list,last)){
            list = solve2(list);
            for(int i=0;i<list.size();i++){
                if(list.size()>=1&&list.get(i).charAt(0)==last){
                    builder.append(list.get(i));
                    last = list.get(i).charAt(list.get(i).length()-1);
                    list.remove(i);
                    break;
                }
            }

        }
        return builder.toString();
    }

    //将字符串数组按照 长度优先 字母顺序次之的规则排序
    public static List<String> solve2(List<String> list){

        List<String> llll = new LinkedList<>();
        String[] str = new String[list.size()];
        for(int i=0;i<str.length;i++){
            str[i] = list.get(i);
        }

        for(int i=0;i< str.length-1;i++){
            for(int j=i+1;j< str.length;j++){
                if(str[i].length()<str[j].length()){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;

                }
                if(str[i].length()==str[j].length()&&str[i].compareTo(str[j])>0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;

                }
            }
        }
        for(int i=0;i<str.length;i++){
            llll.add(str[i]);
        }

        return llll;

    }

    public static boolean pan(List<String> list,char c){
        int count=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).charAt(0)==c){
                count++;
            }
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    //返回去除掉首字符为last的单词的list用于上一步使用
    //public static List<String> solve(char last,List<String> list,StringBuilder builder){
    //    List<String> listReturn = new LinkedList<>();
    //
    //    listReturn = solve2(list);
    //
    //    for(int i=0;i<listReturn.size();i++){
    //        if(listReturn.size()>=1&&listReturn.get(i).charAt(0)==last){
    //            builder.append(listReturn.get(i));
    //            last = listReturn.get(i).charAt(listReturn.get(i).length()-1);
    //            listReturn.remove(i);
    //            break;
    //        }
    //    }
    //
    //
    //    return listReturn;
    //}


}