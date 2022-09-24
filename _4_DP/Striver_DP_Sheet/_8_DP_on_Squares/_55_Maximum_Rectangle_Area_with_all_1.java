package _4_DP.Striver_DP_Sheet._8_DP_on_Squares;

/*
    Time Complexity: O(N*M)
    Space Complexity: O(M)

    Where N is the number of rows in matrix and M is the number of columns in the matrix.
*/

import java.util.Stack;

public class _55_Maximum_Rectangle_Area_with_all_1 {

    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {

        if (mat.length == 0) {
            return 0;
        }

        int maxArea = 0;

        // Stores histogram height in a given row.
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] = height[j] + 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleAreaInHistogram(height));
        }

        return maxArea;
    }

    public static int largestRectangleAreaInHistogram(int[] height) {

        Stack < Integer > stack = new Stack< Integer >();
        int globalMax = 0;
        int i = 0;
        for (; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int top = stack.pop();
                int area = 0;
                if (stack.isEmpty()) {
                    area = height[top] * i;
                } else {
                    area = height[top] * (i - stack.peek() - 1);
                }

                if (area > globalMax) {
                    globalMax = area;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = 0;
            if (stack.isEmpty()) {
                area = height[top] * i;

            } else {
                area = height[top] * (i - stack.peek() - 1);
            }
            if (area > globalMax) {
                globalMax = area;
            }
        }
        return globalMax;
    }
}
