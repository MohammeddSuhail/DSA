package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands

    space: n*m + n*m
    n*m for visited and n*m for recursive stack space

    time:
    8*n*m
 */

public class _4_Find_The_Number_Of_Islands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int c = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    c++;
                }
            }
        }

        return c;
    }

    void dfs(int row, int col, char[][] grid, boolean[][] visited){

        visited[row][col] = true;

        //↖  ⬆  ↗
        //⬅     ➡
        //↙  ⬇  ↘

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int r = row+i;
                int c = col+j;
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == '1' && !visited[r][c]){
                    dfs(r,c,grid,visited);
                }
            }
        }
    }
}
