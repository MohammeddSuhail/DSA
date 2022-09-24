package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-of-nearest-cell-having-1
 */

import java.util.*;

class Node{
        int row,col,steps;
        Node(int r, int c, int s){
            row = r;
            col = c;
            steps = s;
        }
}

public class _8_Distance_Of_Nearest_Cell_Having_1 {
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }


        int[] drow = {0,-1,0,1};
        int[] dcol = {-1,0,1,0};

        //bfs
        while(!q.isEmpty()){
            Node node = q.remove();
            int row = node.row;
            int col = node.col;
            int steps = node.steps;
            dist[row][col] = steps;   //once it is in q, that is raeched so just update dist

            //left, top, right, bottom

            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];

                if(r>=0 && r<n && c>=0 && c<m && !visited[r][c]){
                    visited[r][c] = true;
                    q.add(new Node(r,c,steps+1));
                }
            }
        }

        return dist;
    }
}
