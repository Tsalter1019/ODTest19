package Deke;

import java.util.ArrayList;
import java.util.List;

/** 给定一个非空数组(列表)    起元素数据类型为整型  请按照数组元素十进制最低位从小到大进行排序   十进制最低位相同的元素，相对位置保持不变
        当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位
        输入描述
        给定一个非空数组(列表)    其元素数据类型为32位有符号整数    数组长度为[1,1000]
       输出排序后的数组
       输入
       1,2,5,-21,22,11,55,-101,42,8,7,32
       输出
       1,-21,11,-101,2,22,42,32,5,55,7,8

        */
public class A27 {
    public static void main(String[] args) {

    }
    //public static int[] solution(int[] arr){
    //    int[] result = new int[arr.length];
    //
    //}
    //public static boolean whichBigger(int a,int b){
    //
    //}


    public static List<Integer>  listToString(List<String> list){
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(Integer.parseInt(list.get(i)));
        }
        return list1;
    }

}