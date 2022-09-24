package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges
 */

import java.util.*;

class Pair{
    int row,col,tm;

    Pair(int row, int col,int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class _6_Rotten_Oranges {
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int nFresh = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2)
                    q.add(new Pair(i,j,0));
                else if(grid[i][j] == 1)
                    nFresh++;
            }
        }

        int[] drow = {0,-1,0,+1};
        int[] dcol = {-1,0,1,0};

        /*
        All rotten oranges are already put into q
        for each we iterate and do bfs
        */
        int t=0;
        while(!q.isEmpty()){
            Pair node = q.remove();
            int row = node.row;
            int col = node.col;
            int tm = node.tm;
            t = Math.max(t,tm);

            for(int i = 0; i< 4; i++){
                int r = row+drow[i];
                int c = col+dcol[i];

                if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1){
                    grid[r][c] = 2;
                    q.add(new Pair(r,c,tm+1));
                    nFresh--;
                }
            }
        }

        if(nFresh != 0) //there are still fresh oranges
            return -1;
        else
            return t;
    }
}
