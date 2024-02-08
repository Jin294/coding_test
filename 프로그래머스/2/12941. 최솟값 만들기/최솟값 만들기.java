import java.util.*;

class Solution {
    public int solution (int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += A[i] * B[len - 1 - i];
        }

        return sum;
    }
}
