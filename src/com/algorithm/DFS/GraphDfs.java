package com.algorithm.DFS;

/**
 * 图深度优先遍历
 * 编写程序对给定的 有向图（不一定连通） 进行深度优先遍历，图中包含n个顶点，编号为0至n-1。本题限定在深度优先遍历过程中，如果同时出现多个待访问的顶点，
 * 则优先选择编号最小的一个进行访问，以顶点0为遍历起点。
 * 输入格式:
 * 输入第一行为两个整数n和e，分别表示图的顶点数和边数，其中n不超过20000，e不超过50。接下来e行表示每条边的信息，每行为两个整数a、b，表示该边的端点编号，
 * 但各边并非按端点编号顺序排列。
 * 输出格式:
 * 输出为一行整数，每个整数后一个空格，即该有向图的深度优先遍历结点序列。
 * 输入样例1:
 *
 * 3 3
 * 0 1
 * 1 2
 * 0 2
 *
 * 输出样例1:
 *
 * 0 1 2
 *
 * 输入样例2:
 *
 * 4 4
 * 0 2
 * 0 1
 * 1 2
 * 3 0
 *
 * 输出样例2:
 *
 * 0 1 2 3
 *
 * 深度优先遍历的主要思想：
 * 首先以一个未被访问过的顶点作为起始顶点，延当前顶点的边走到未访问过的顶点；当没有未访问过的顶点时，则返回上一个顶点，继续试探访问别的顶点，知道所有的顶点都被访问过。
 * 显然，深度优先遍历时沿着图的某一条分支遍历直到末端，即“一条路走到黑”，然后再回溯，再沿着另一条进行同样的遍历，直到所有的顶点都被访问过为止
 */

import java.util.Scanner;

public class GraphDfs {
    static Scanner scan = new Scanner(System.in);

    //sum记录访问过多少个顶点
    static int sum = 0;
    //n表示顶点的数量
    static int n;
    //e表示边的数量
    static int e;
    //输入顶点数和边数
    static {
        n = scan.nextInt();
        e = scan.nextInt();
    }
    //book用来标记顶点已经访问过
    static int[] book = new int[n];
    //a用来存储图的邻接矩阵存储法
    static int[][] a = new int[n][n];

    public static void main(String[] args) {

        //初始化二维矩阵，对角线为0，其他为无穷
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    a[i][j] = 0;
                else
                    a[i][j] = 99;
            }
        }

        //输入顶点之间的有向边
        for (int i = 0; i < e; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            a[x][y] = 1;
        }

        //图有可能不连通，因此深度优先遍历每个结点
        for (int i = 0; i < n; i++) {
            if (book[i] == 0) {
                book[i] = 1;
                dfs(i);
            }
        }

    }

    //cur是当前所在的顶点编号
    public static void dfs(int cur) {
        book[cur] = 1;

        //每访问一个结点，sum就加1
        sum++;

        System.out.print(cur + " ");

        //所有的顶点已经访问过就直接退出
        if (sum == n)
            return;

        //从第一个顶点依次尝试，查看哪些顶点与当前顶点cur有边相连
        for (int i = 0; i < n; i++) {

            //判断当前顶点cur到顶点i是否有边，并判断顶点i是否已经访问过
            if (a[cur][i] == 0 && book[i] == 0) {

                //标记顶点已经访问过
                book[i] = 1;
                //从顶点i再出发继续遍历
                dfs(i);
            }
        }
        return;
    }

}

