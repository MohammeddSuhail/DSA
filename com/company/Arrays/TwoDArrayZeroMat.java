package com.company.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArrayZeroMat {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        //System.out.println(matrix);

    }

    static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    //add to list
                    ArrayList listItem= new ArrayList<>(Arrays.asList(i,j));
                    list.add(listItem);
                }
            }
        }

        for(int k=0;k<list.size();k++){
            ArrayList<Integer> lis = list.get(0);
            for(int j=0;j<n;j++){
                int IndexOne = (int) lis.get(0);
                matrix[IndexOne][j]=0;
            }
            for(int i=0;i<m;i++){
                int IndexTwo= (int) lis.get(1);
                matrix[i][IndexTwo]=0;
            }
        }
    }
}
