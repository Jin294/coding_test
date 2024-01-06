import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long lt = 0;
        long rt = (long) Arrays.stream(times).max().getAsInt() * (long) n;

        long mid = 0l;
        while (lt <= rt) {
            mid = lt + (rt - lt) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) { // 시간이 길다 -> 줄여야 함
                rt = mid - 1l;
            } else {  // 시간이 짧다 -> 늘려야 함
                lt = mid + 1l;
            }
        }

        return lt;
    }
}
