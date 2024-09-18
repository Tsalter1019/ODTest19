package leetcodeDaily2024;

public class LCR105 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new LCR105().maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        if(r==0){
            return 0;
        }
        int c = grid[0].length;

        int maxArea = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
                }

            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid,int r,int c){
        int area = 1;
        int rn = grid.length;
        int cn = grid[0].length;
        grid[r][c] = 0;

        if(r-1>=0 && grid[r-1][c] == 1) area+=dfs(grid,r-1,c);
        if(r+1<rn && grid[r+1][c] == 1) area+=dfs(grid,r+1,c);
        if(c-1>=0 && grid[r][c-1] == 1) area+=dfs(grid,r,c-1);
        if(c+1<cn && grid[r][c+1] == 1) area+=dfs(grid,r,c+1);

        return area;
    }
}
