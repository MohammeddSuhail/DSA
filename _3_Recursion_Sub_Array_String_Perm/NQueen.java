package _3_Recursion_Sub_Array_String_Perm;

import java.util.*;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        //Time Complexity:  O(N!* N), Space Complexity: O(N^2) excluding ans
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        //initializing every char in board to be '.'
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        nQueen(0, board, ans);

        return ans;
    }

    void nQueen(int col, char[][] board, List<List<String>> ans){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        //trying to put queen in every row of the col if possible
        for(int row=0; row<board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                nQueen(col+1, board , ans);
                board[row][col] = '.';
            }
        }
    }

    //u need to check only ← ,↙ and ↖ . You need not check others because u r filling columns from left to right
    boolean isSafe(int row, int col, char[][] board){
        int dupRow = row;
        int dupCol = col;

        //check ←
        while(col>=0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }

        //check ↙
        row = dupRow;
        col = dupCol;

        while(row<board.length && col>=0){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }

        //check ↖
        row = dupRow;
        col = dupCol;

        while(row>=0 && col>=0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        return true;
    }

    //constructing List<String> from char[][] board
    List<String> construct(char[][] board){
        List<String> a = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            a.add(s);
        }

        return a;
    }
}



//in this soln we have avoided O(3n) from isSafe by using leftRow[],upperDiagonal[],lowerDiagonal[] to keep track of Q
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //Time Complexity: O(N! * N), Space Complexity: O(N^2) excluding ans
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        //intializing every char in board to be '.'
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n - 1];
        int lowerDiagonal[] = new int[2*n - 1];

        nQueen(0, board, ans, leftRow, lowerDiagonal, upperDiagonal);

        return ans;
    }

    void nQueen(int col, char[][] board, List<List<String>> ans,int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        //trying to put queen in every row of the col if possible
        for(int row=0; row<board.length; row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[(board.length-1)+(col - row)]==0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[(board.length-1)+(col - row)] = 1;

                nQueen(col+1, board , ans, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[(board.length-1)+(col - row)] = 0;
            }
        }
    }

    //constructing List<String> from char[][] board
    List<String> construct(char[][] board){
        List<String> a = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            a.add(s);
        }

        return a;
    }
}

