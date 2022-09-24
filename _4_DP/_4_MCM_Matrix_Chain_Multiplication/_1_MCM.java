package _4_DP._4_MCM_Matrix_Chain_Multiplication;

/*
      Array will be given.
      then:
      a1=(arr[0],arr[1]),a2=(arr[1],arr[2]),a3=(arr[2],arr[3]),..  makes the dimensions of 2D matrices
      we have to decide where to put brackets(which one to multiply together, basically grouping) to minimize cost in a1,a2,a3,...

      cost of multiplication of (40 x 30) * (30 x 60) is
                                   cost => 40*30*60  resulting matrix: (40 x 60)

      if it was ((40 x 30) * (30 x 60)) * (60 x 30)
                  40*30*60 + cost of((40 x 60) * (60 x 30))
         cost:   (40*30*60)+ (40*60*30)

      Goal is to minimize the cost

            i                   j
      10    20    30     40     50
            A      B      C      D

       (A)(BCD)  (AB)(CD)   (ADC)(D)

       so k = i to j-1
            solve(i,k) + solve(k+1,n)

              (A*B)*C
       ((40 x 30) * (30 x 60)) * (60 x 30)
               (40*60) * (60 x 30)
                    (40*30)        => cost: 40*60*30
                                            arr[i-1] * k * arr[j]


 */


public class _1_MCM {
    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        int n = arr.length;

        System.out.println("Minimum cost of multiplication using just recursion: "+solve(arr , 1, n-1));


        //memoization
        int[][] t=new int[n][n];
        for (int i = 0; i <n ; i++)
            for (int j = 0; j <n ; j++)
                t[i][j]=-1;

        System.out.println("Minimum cost of multiplication using recursion + memoization : "+solveMemo(arr , 1, n-1,t));
    }

    /*  Recursion
        time complexity: O(n^n)
        space complexity: O(n)
     */

    static int solve(int[] arr, int i, int j){
        if(i==j)
            return 0;

        int min =Integer.MAX_VALUE;

        //below no k<=j-1, because at k=j, partition would be (i,j) and (j+1,j)=> ,which means there was no partition so
        for (int k = i; k <= j-1 ; k++) {//cost for multiplying 2 div + div1 mul internally will also take some cost + div2 internal cost
            int temp_ans =  (arr[i-1]*arr[k]*arr[j]) + solve(arr,i,k) + solve(arr,k+1,j);
            min = Math.min(min,temp_ans);
        }

        return min;
    }


    /*  Memoization:
        Time Complexity: O(N * N * N) , last N foreach call at ,max N times k loop
        Note: It is the upper bound. In real Time Complexity will be much lesser.

        Space Complexity: O(N * N)
        Where 'N' is the number of elements in the array.
    */

    static int solveMemo(int[] arr, int i, int j, int[][] t){
        if(i==j) //only one matrix in division, so cost is 0
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int min =Integer.MAX_VALUE;

        //below no k<=j-1, because at k=j, partition would be (i,j) and (j+1,j)=> ,which means there was no partition so
        for (int k = i; k <= j-1 ; k++) {
            int temp_ans = (arr[i-1]*arr[k]*arr[j]) + solveMemo(arr,i,k,t) + solveMemo(arr,k+1,j,t);
            min = Math.min(min,temp_ans);
        }

        return t[i][j] = min;
    }
}
