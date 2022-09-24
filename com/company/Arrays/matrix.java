package com.company.Arrays;

import java.util.ArrayList;
import java.util.List;

public class matrix {
    public static void main(String[] args) {
        int[][] mat={{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> ans = luckyNumbers(mat);
        System.out.println(ans.toString());
    }

    static List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min;
        boolean yes;

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            min = 0;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<matrix[i][min])
                    min=j;
            }
            yes=false;
            int ele = matrix[i][min];
            for(int k=0;k<m;k++){
                if(ele >= matrix[k][min]){
                    yes=true;
                }else{
                    yes=false;
                    break;
                }
            }
            if(yes){
                list.add(ele);
            }
        }

        return list;
    }
}
