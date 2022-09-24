package _2_SlidingWindow.FixedWindow;

//max ele of every window size k

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Prog4 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,2};
        int k = 3;
        ArrayList<Integer> ans = getMaxEles(arr,k);
        System.out.println(ans);
    }

    //better one because it stores indexes in ArrayDequeue rather than ele itself, otherwise this would lead to removal of other similar ele
    public int[] maxSlidingWindow(int[] arr, int k) {
        // Time Complexity: O(N)+O(N)=>O(N) and Space Complexity: O(K)
        int i = 0, j = 0, n = arr.length, r = 0;
        int[] ans = new int[n - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();   //q will hold index of ele in descending order

        while (j < n) {
            if (q.isEmpty()) {
                q.add(j);
            } else {
                while (!q.isEmpty() && arr[q.getLast()] < arr[j]) {
                    q.removeLast();
                }
                q.addLast(j);
            }

            if (j - i + 1 < k) {
                j++;
            } else {
                ans[r++] = arr[q.getFirst()]; //first ele of deque will be max so
                q.remove(i);      //removing particular ele from q which is out of window
                i++;
                j++;
            }
        }

        return ans;
    }

    private static ArrayList<Integer> getMaxEles(int[] arr, int k) {

        int i=0, j=0, n= arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();   //q will hold ele in descending order

        while(j<n){
            if(q.isEmpty()){
                q.add(arr[j]);
            }else {
                while(!q.isEmpty() && q.getLast()<arr[j]){
                    q.removeLast();
                }
                q.addLast(arr[j]);
            }
            if(j-i+1 < k) {
                j++;
            }
            else{
                ans.add(q.getFirst()); //first ele of deque will be max so
                q.remove(arr[i]);      //removing particular ele from q which is out of window
                i++;
                j++;
            }
        }

        return ans;
    }
}
