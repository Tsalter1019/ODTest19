package com.algorithm.DFS;


public class Dfs1 {
    static boolean isVisit[];
    public static void main(String[] args) {
        int map[][]=new int[7][7];
        isVisit=new boolean[7];
        map[0][1]=map[1][0]=1;
        map[0][2]=map[2][0]=1;
        map[0][3]=map[3][0]=1;

        map[1][4]=map[4][1]=1;
        map[1][5]=map[5][1]=1;
        map[2][6]=map[6][2]=1;
        map[3][6]=map[6][3]=1;

        isVisit[0]=true;
        dfs(0,map);//从0开始遍历
    }
    private static void dfs(int index,int map[][]) {
        // TODO Auto-generated method stub
        System.out.println("访问"+(index+1)+"  ");
        for(int i=0;i<map[index].length;i++)//查找联通节点
        {
            if(map[index][i]>0&&isVisit[i]==false)
            {
                isVisit[i]=true;
                dfs(i,map);
            }
        }
        System.out.println((index+1)+"访问结束 ");
    }
}
/**
 * 访问1
 * 访问2
 * 访问5
 * 5访问结束
 * 访问6
 * 6访问结束
 * 2访问结束
 * 访问3
 * 访问7
 * 访问4
 * 4访问结束
 * 7访问结束
 * 3访问结束
 * 1访问结束
 */