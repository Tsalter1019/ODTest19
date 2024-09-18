package leetcodeDaily2024;

public class B1905 {
    public static void main(String[] args) {
        int[][] grid1= {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2= {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(new B1905().countSubIslands(grid1,grid2));
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        if(m==0){
            return 0;
        }
        int n = grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid1[i][j]==1 && grid2[i][j]==1){
                    grid2[i][j]++;
                }
            }
        }

        int islandNum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==2 && dfs(grid2,i,j)){
                    ++islandNum;
                    dfs(grid2,i,j);
                }
            }
        }
        return islandNum;
    }

    public boolean dfs(int[][] grid,int r,int c){


        int rn = grid.length;
        int cn = grid[0].length;
        if(r<0||r>=rn||c<0||c>=cn){
            return true;
        }
        if(grid[r][c]!=2){              
            return grid[r][c]==0;
        }
        grid[r][c] = 0;

        boolean down =  dfs(grid,r-1,c);
        boolean up =  dfs(grid,r+1,c);
        boolean right =  dfs(grid,r,c-1);
        boolean left =  dfs(grid,r,c+1);
        return down&up&right&left;
    }
}
