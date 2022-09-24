package Stacks;

/*
    https://www.interviewbit.com/problems/nearest-smaller-element/
 */

import java.util.*;

public class _2_Next_Smaller_Element {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();

        int[] ans  = new int[A.length];

        for(int i=0;i<A.length;i++){
            //pop ele's from stack which are greater than ele at i,becuase they can't be answers for
            //other ele's on left since cur ele is smaller than those
            while(!st.isEmpty() && st.peek()>=A[i])
                st.pop();

            if(!st.isEmpty())
                ans[i] = st.peek();
            else
                ans[i] = -1;

            st.push(A[i]); //because cur ele smaller cpmpared to other ele till now ,
        }                  //so this could be answer for other ele's to it's right

        return ans;
    }
}
