package Problems;

/*
    https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1?page=3&category[]=Arrays&category[]=Strings&sortBy=submissions
 */

import java.util.ArrayList;

public class _1_Print_Matrix_Spirally {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();

        spiralFill(matrix, 0, r-1, 0, c-1, ans);

        return ans;
    }

    static void spiralFill(int matrix[][], int row1, int row2, int col1, int col2, ArrayList<Integer> ans){
        if(row1>row2 || col1>col2)
            return;


        for(int j=col1; j<=col2; j++){
            ans.add(matrix[row1][j]);
        }

        for(int i=row1+1; i<=row2;i++){
            ans.add(matrix[i][col2]);
        }

        //if only one row
        if(row1 != row2){
            for(int j=col2-1; j>=col1;j--){
                ans.add(matrix[row2][j]);
            }
        }

        //if only one column
        if(col1 != col2){
            for(int i=row2-1; i>=row1+1;i--){
                ans.add(matrix[i][col1]);
            }
        }

        spiralFill(matrix, row1+1, row2-1, col1+1, col2-1,ans);
    }
}
