package Deke;

import java.util.*;
import java.util.stream.Collectors;

/**
  给定一个射击比赛成绩单
  包含多个选手若干次射击的成绩分数
  请对每个选手按其最高三个分数之和进行降序排名
  输出降序排名后的选手id序列
  条件如下
    1. 一个选手可以有多个射击成绩的分数，且次序不固定
    2. 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手
    3. 如果选手的成绩之和相等，则相等的选手按照其id降序排列

   输入描述:
     输入第一行
         一个整数N
         表示该场比赛总共进行了N次射击
         产生N个成绩分数
         2<=N<=100

     输入第二行
       一个长度为N整数序列
       表示参与每次射击的选手id
       0<=id<=99

     输入第三行
        一个长度为N整数序列
        表示参与每次射击选手对应的成绩
        0<=成绩<=100

   输出描述:
      符合题设条件的降序排名后的选手ID序列

   示例一
      输入:
        13
        3,3,7,4,4,4,4,7,7,3,5,5,5
        53,80,68,24,39,76,66,16,100,55,53,80,55
      输出:
        5,3,7,4
      说明:
        该场射击比赛进行了13次
        参赛的选手为{3,4,5,7}
        3号选手成绩53,80,55 最高三个成绩的和为188
        4号选手成绩24,39,76,66  最高三个成绩的和为181
        5号选手成绩53,80,55  最高三个成绩的和为188
        7号选手成绩68,16,100  最高三个成绩的和为184
        比较各个选手最高3个成绩的和
        有3号=5号>7号>4号
        由于3号和5号成绩相等  且id 5>3
        所以输出5,3,7,4
   */
public class A86{
    public static void main(String[] args) {
        int n = 13;
        int[] arr = {3,3,7,4,4,4,4,7,7,3,5,5,5};
        int[] brr = {53,80,68,24,39,76,66,16,100,55,53,80,55};
        System.out.println(solution(n,arr,brr));
    }
    public static String solution(int n,int[] arr,int[] brr){
        Map<Integer,Integer> integerListMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] isEffective = new boolean[n];
        List<Integer> list = new LinkedList<>();
        Arrays.fill(isEffective,false);

        Map<Integer,Integer> map = new HashMap<>();//统计每个数出现的次数key为id value为次数
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int y = map.get(arr[i]);
                map.put(arr[i],y+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for(int j=0;j<n;j++){
            for(int i:map.keySet()){
                if(i==arr[j]&&map.get(i)>=3){
                    isEffective[j] = true;//次数大于3的赋有效次数
                    break;
                }
            }
        }

        List<Integer> listReturn = new LinkedList<>();
        int sum = 0;
        for(int i=0;i<n-1;i++){
            if(isEffective[i]&&(!integerListMap.keySet().contains(arr[i]))){
                list.add(brr[i]);
                for(int j=i+1;j<n;j++){
                    if(arr[i]==arr[j]){
                        list.add(brr[j]);
                    }
                }
                Collections.sort(list);
                Collections.reverse(list);

                for(int k=0;k<3;k++){//取最大的三个和
                    sum+=list.get(k);
                }
                integerListMap.put(arr[i],sum);//key为id  value为该有效选手的最大三个成绩的和
                sum=0;
                list = new LinkedList<>();
            }

        }

        //排序map 输出key,   规则:value大的优先  value相同比较key大小
        for(int i:integerListMap.keySet()){
            listReturn.add(i);
        }
        Collections.sort(listReturn, (o1, o2) -> {
            if(integerListMap.get(o1)<integerListMap.get(o2)){
                return 1;
            }else if(integerListMap.get(o1)==integerListMap.get(o2)){
                return o2.compareTo(o1);
            }else{
                return -1;
            }
        });

        //拼装
        for(int i : listReturn){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }

        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
