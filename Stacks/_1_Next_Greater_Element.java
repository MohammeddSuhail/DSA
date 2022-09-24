package Stacks;

/*
    https://leetcode.com/problems/next-greater-element-ii/description/
 */

import java.util.*;

public class _1_Next_Greater_Element {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack < Integer > st = new Stack < > ();

        //we start from 2(n-1) because, we are goining through array twice to assign next ele for last eles, rotational also so
        for (int i = 2*(n-1); i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i % n]) { //if stack top is less then the current element, remove it
                st.pop();                                   //because for other ele's cur ele may be next greater ele, bit not
            }                                               //since removed ele's were<=cur ele, they can never be next greater ele

            if (i < n) {
                if (!st.isEmpty())
                    nge[i] = st.peek();
                else
                    nge[i] = -1;
            }

            st.push(nums[i % n]); //add to stack, because this could be greater element for other ele's
        }
        return nge;
    }
}
