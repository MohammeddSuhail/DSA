package Problems;
//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.

public class _3 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix,3));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length, n = matrix[0].length;

//         //finding in which array ele is and binary search
//         for(int i=0;i<m;i++){
//             if(target >= matrix[i][0]  && target <= matrix[i][n-1]){
//                 return binaySearch(matrix[i],target);
//             }
//         }
//         return false;

        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
        }
        return false;
    }


//     static boolean binaySearch(int[] arr,int target){
//         int n = arr.length;

//         int l=0, r=n-1;

//         while(l<=r){
//             int mid = (l + r)/ 2;

//             if(arr[mid]==target)
//                 return true;
//             else if(target>arr[mid])
//                 l=mid+1;
//             else
//                 r=mid-1;
//         }
//         return false;
//     }
}
