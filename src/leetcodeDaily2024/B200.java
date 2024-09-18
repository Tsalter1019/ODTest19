package leetcodeDaily2024;

public class B200 {
    public static void main(String[] args) {
//        char[][] grid  = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid  = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(new B200().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int rn = grid.length;
        if(rn==0){
            return 0;
        }
        int cn = grid[0].length;

        int islandNum = 0;
        for(int i=0;i<rn;i++){
            for(int j=0;j<cn;j++){
                if(grid[i][j]=='1'){
                    islandNum++;
                    dfs(grid,i,j);
                }
            }
        }
        return islandNum;

    }
    private void dfs(char[][] grid,int r,int c){
        int rn = grid.length;
        int cn = grid[0].length;

        grid[r][c]='0';

        if(r-1>=0 && grid[r-1][c]=='1') dfs(grid,r-1,c);
        if(r+1<rn && grid[r+1][c]=='1') dfs(grid,r+1,c);
        if(c-1>=0 && grid[r][c-1]=='1') dfs(grid,r,c-1);
        if(c+1<cn && grid[r][c+1]=='1') dfs(grid,r,c+1);
    }


}
