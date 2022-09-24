package Problems;

public class Pat {
    public static void main(String[] args) {
        pattern(4,1);
        System.out.println();
        patter(4,0);
        System.out.println();
        patt(4,0);
    }

    //one way
    static void pattern(int n,int i){
        if(i>n){
            return;
        }
        for (int j = 1; j <= n-i+1; j++) {
            System.out.print("*");
        }
        System.out.println();
        pattern(n,i+1);
    }

    //other ways
    static void patter(int r , int c){
        if(r==0){
            return;
        }

        if(c<r){
            System.out.print("*");
            patter(r,c+1);
        }else{
            //if c==r
            System.out.println();
            patter(r-1,0);
        }
    }

    static void patt(int r , int c){
        if(r==0){
            return;
        }

        if(c<r){
            patt(r,c+1);
            System.out.print("*");
        }else{
            //if c==r
            patt(r-1,0);
            System.out.println();
        }
    }
}
