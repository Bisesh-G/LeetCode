import java.util.*;

class Solution {

    public int[] nextSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int[] prevSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] next = nextSmaller(heights, n);
        int[] prev = prevSmaller(heights, n);

        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int length = heights[i];

            if (next[i] == -1) {
                next[i] = n;
            }

            int breadth = next[i] - prev[i] - 1;

            int newArea = length * breadth;

            area = Math.max(area, newArea);
        }

        return area;
    }
}
