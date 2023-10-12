package com.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 在N*M迷宫中  计算并输出S到G的最短路径 ‘#’，‘。’，‘S’，‘G’分别表示墙壁、通道、起点、终点
 *
 *                #S######
 *                ....#.##
 *                .#.##..#
 *                .#......
 *                ##.#.###
 *                ...#...#
 *                .####.##
 *                ...#....
 *                .####.##
 *                ...#...G
 *
 * 键入n,m,和迷宫；记录S和G的位置；DBS广搜，创建两个一维数组记录起点和终点位置，用 d[][] 标记走过路径；具体操作请看代码。
 */

public class Labyrinth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行数
        int m = sc.nextInt();//列数
        String t = sc.nextLine();
        char[][] map = new char[n][m];
        int[] begin = new int[2]; //起点位置
        int[] end = new int[2];  //终点位置

        for (int i = 0; i < n; i++) { //按行输入字符,共输入n行,每输入一行，就依次判断是否 起点或终点
            String s = sc.nextLine();
            map[i] = s.toCharArray();
            if (s.contains("S")) {  // 当字符串 s 包含 " " 内指定的 char值时，方法返回true
                begin[0] = i;  //记录起点“s"所在行数，  下一行代码记录起点“s"所在列数
                begin[1] = s.indexOf("S");//查找指定字符"s"在其字符串中的下标。若"s"存在则返回所在字符串下标；不在则返回-1.
            }
            if (s.contains("G")) {
                end[0] = i;   //记录终点”G“所在 行数列数
                end[1] = s.indexOf("G");
            }
        }
        Solution put=new Solution();
        System.out.println( put.bfs(map, begin, end));
    }

    public static class Solution {
        public int bfs(char[][] map, int[] begin, int[] end) {
            int[] dx = {1, 0, -1, 0};//移动的四个方向
            int[] dy = {0, 1, 0, -1};
            int[][] d = new int[map.length][map[0].length];// 记录 到终点最短路径数的二维数组

            Queue<int[]> que = new LinkedList<int[]>();  //储存将要进行处理的点
            for (int i = 0; i < d.length; i++) {  //将所有的位置都初始化为最大
                for (int j = 0; j < d[0].length; j++) {
                    d[i][j] = Integer.MAX_VALUE; //Integer.MAX_VALUE 是整型可以支持的最大数
                }
            }
            que.offer(begin);//将起始点放入队列
            d[begin[0]][begin[1]] = 0;//将起始点最短路径设为0
            while (!que.isEmpty()) {// 队列非空时，执行循环
                int[] current = que.poll(); //取出队列中最前端的点
                if (current[0] == end[0] && current[1] == end[1])  break;//如果是终点则结束,最短路径为0
                for (int i = 0; i < 4; i++) {//四个方向循环

                    int ny = current[0] + dy[i];
                    int nx = current[1] + dx[i];
                    //判断是否可以走
                    if (ny >= 0 && ny < d.length && nx >= 0 && nx < d[0].length && map[ny][nx] != '#' && d[ny][nx] == Integer.MAX_VALUE) {

                        d[ny][nx] = d[current[0]][current[1]] + 1;//如果可以走，则将该点的距离加1
                        int[] c = {ny, nx};//将该点放入队列等待下次处理
                        que.offer(c);
                    }
                }
            }
            return d[end[0]][end[1]];
        }
    }
}


