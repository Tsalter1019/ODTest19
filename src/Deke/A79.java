package Deke;

import java.util.*;

/**
   某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
   现需要按照身高由低到高排列，
   对身高相同的人，按体重由轻到重排列，
   对于身高体重都相同的人，维持原有的编号顺序关系。
   请输出排列后的学生编号
   输入描述：
      两个序列，每个序列由N个正整数组成，(0<n<=100)。
      第一个序列中的数值代表身高，第二个序列中的数值代表体重，
   输出描述：
      排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
   实例一：
      输入:
       5
       100 100 120 130 120
       40 30 60 50 30
      输出:
       2134
   */
public class A79 {
    public static void main(String[] args) {
        int N = 5;
        int[] arr1 = {100,100,120,130,120};
        int[] arr2 = {40,30,60,50,30};
        solution1(N,arr1,arr2);
    }
    public static void solution1(int N,int[] h,int[] w){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        list.sort((o1,o2) -> {
            if(h[o1-1]<h[o2-1]){
                return -1;
            }else if(h[o1-1]==h[o2-1]){
                //return compareTo(w[o1-1],w[o2-1]);
                return Integer.valueOf(w[o1-1]).compareTo(Integer.valueOf(w[o2-1]));
            }else{
                return 1;
            }
        });
        for(int i:list){
            System.out.print(i+" ");
        }
    }
    public static int compareTo(int x,int y){
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    private static void solution(int N,int[] h,int[] w){
        LinkedList<Stu> stus = new LinkedList<>();
        for(int i=0;i<N;i++){
            Stu stu = new Stu(i+1,h[i],w[i]);
            stus.add(stu);
        }
        stus.sort((o1, o2) -> o1.h == o2.h ? (o1.w - o2.w) : o1.h - o2.h);
        StringBuilder builder = new StringBuilder();
        stus.forEach(x -> builder.append(x.id).append(" "));
        System.out.println(builder.substring(0,builder.length() - 1));
    }
    static class Stu{
        int id;
        int h;
        int w;
        public Stu(int id,int h,int w){
            this.id =id;
            this.h=h;
            this.w=w;
        }
    }

}