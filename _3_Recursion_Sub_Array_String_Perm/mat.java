package _3_Recursion_Sub_Array_String_Perm;

import java.util.ArrayList;
import java.util.List;

public class mat {
    public static void main(String[] args) {
        //int[][] arr ={{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8}};
        int[][] arr ={{7},{9},{6}};
        int m = arr.length;
        int n = arr[0].length;
        List<Integer> list = new ArrayList<>();
        list= Spiral(m,n,arr,0,n-1,m-1,list);
        System.out.println(list);
    }

    static List<Integer> Spiral(int m, int n, int[][] arr ,int startPos,int endPos,int rowEndIndex,List<Integer> list){
        if(m<=0 || n<=0){
            return list;
        }

        //for ->
        for (int j = startPos; j <=endPos; j++) {
            list.add(arr[startPos][j]);
        }

        //for down
        for (int j = startPos+1; j <= rowEndIndex; j++) {
            list.add(arr[j][endPos]);
        }

        //condition checks whether it has only 1 row, then no <- printing
        if (m!=1){
            //for <-
            for (int i = endPos-1; i >=startPos ; i--) {
                list.add(arr[rowEndIndex][i]);
            }
        }

        //condition checks whether it has only 1 col, then no up printing
        if(n!=1){
            //for up
            for (int i=rowEndIndex-1;i>startPos;i--){
                list.add(arr[i][startPos]);
            }
        }

        return Spiral(m-2,n-2,arr,startPos+1,endPos-1,rowEndIndex-1,list);
    }


}
