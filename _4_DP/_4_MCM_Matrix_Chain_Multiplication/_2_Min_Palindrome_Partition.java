package _4_DP._4_MCM_Matrix_Chain_Multiplication;

public class _2_Min_Palindrome_Partition {
    public static void main(String[] args) {
        String s = "liahussuhail";
        int n = s.length();

        int[][] t=new int[n+1][n+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        solve(s,0,n,t,Integer.MAX_VALUE);
    }


    static int solve(String s,int i,int j,int[][] t,int min){
        if(i>=j){
            return 0;
        }

        if(isPalindrome(s,i,j)){
            return 0;
        }

        if(t[i][j]!=-1){
            return t[i][j];
        }

        for(int k=i;k<j;k++){
            int temp = 1+solve(s,i,k,t,min)+solve(s,k+1,j,t,min);
            min = Math.min(min,temp);
            t[i][j]=min;
        }

        return t[i][j];
    }

    static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}