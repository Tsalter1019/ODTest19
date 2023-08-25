package com.OD;


public class Wanggezhongdezuiduanlujin48 {
        private static int res;
        public int shortestPath(int[][] grid, int k) {
            res=-1;
            dfs(grid,k,0,0,0);
            return res;
        }
        public static void dfs(int[][] grid,int k,int ans,int i,int j){
            if (i==grid.length-1 && j==grid[0].length-1){
                res=Math.max(res,ans);
            }else if (i==grid.length || j==grid[0].length){
                return ;
            }
            int[][] directions = {{1,0},{0,1}};
            for (int[] direction : directions){
                int nextI=i+direction[0],nextJ=j+direction[1];
                if (nextI>=grid.length || nextJ>=grid[0].length){
                    continue;
                }
                if (grid[nextI][nextJ]==0){
                    ans++;
                    grid[nextI][nextJ]=1;
                    dfs(grid, k, ans, nextI, nextJ);
                    grid[nextI][nextJ]=0;
                    ans--;
                }else if (k>0){
                    ans++;
                    k--;
                    dfs(grid, k, ans, nextI, nextJ);
                    k++;
                    ans--;
                }
            }
        }
    }

