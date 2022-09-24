package Stacks;

/*
    https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

import java.util.*;

public class _3_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        /*
        //complexity: time = O(n*n) for each height we are traversing through array so, space = O(1)
        int maxArea = 0, n=heights.length;

        //for each height we check if heights[i] has <= value
        for(int h=0;h<n;h++){
            int sum=0;
            boolean flag = false;

            for(int i=0;i<n;i++){
                if(heights[i] >= heights[h]){
                    sum+=heights[h];
                    flag = true; //contiguously present
                }else{
                    flag = false; //contiguously broke
                }
                if(flag == false){ //whenever contiguous broke check
                    maxArea = Math.max(maxArea,sum);
                    sum=0;
                }
            }
            maxArea = Math.max(maxArea,sum); //for last ele we couldn't check, so we are putting this check for it
        }

        return maxArea;

        */

        /* not tried to understand
        int n=arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;*/

        //optimized solution
        //Time Complexity: O( N )
        //Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        //next ele < curEle on left,   more like last ele >= curEle on left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = st.peek() + 1; // +1 because, we need next_ele of ele <= curEle
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        //next ele < curEle on right, more like last ele >= curEle on right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1)); //height*width
        }                                                                           //width is basically j-i+1
        return maxA;
    }
}
