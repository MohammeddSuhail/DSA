package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm

    Time Complexity: O(n*m)
    Space Complexity: O(1)
 */

public class _5_Flood_Fill_Algorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // if old and new color is same
        if(image[sr][sc] == newColor)
            return image;

        dfs(sr,sc,image[sr][sc],newColor,image);


        return image;
    }

    void dfs(int row, int col, int oldColor,int newColor, int[][] image){

        image[row][col] = newColor;

        //move left,right,top,bottom
        if(col-1 >=0 && image[row][col-1] == oldColor)
            dfs(row,col-1,oldColor,newColor,image);

        if(col+1 < image[0].length && image[row][col+1] == oldColor)
            dfs(row,col+1,oldColor,newColor,image);

        if(row-1 >= 0 && image[row-1][col] == oldColor)
            dfs(row-1,col,oldColor,newColor,image);

        if(row+1 < image.length && image[row+1][col] == oldColor)
            dfs(row+1,col,oldColor,newColor,image);
    }
}
