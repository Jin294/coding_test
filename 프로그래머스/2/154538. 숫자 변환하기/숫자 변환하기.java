import java.util.*;

class Solution {
    static int f = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] arr = new int[y + 1];
        Arrays.fill(arr, f);
        arr[x] = 0;
        for (int i = x; i <= y; i++) {
            if (arr[i] == f) continue;
            
            if (i + n <= y) {
                arr[i + n] = arr[i + n] == 0 ? arr[i] + 1 : Math.min(arr[i + n], arr[i] + 1);
            }
            
            if (i * 2 <= y) {
                arr[i * 2] = arr[i * 2] == 0 ? arr[i] + 1 : Math.min(arr[i * 2], arr[i] + 1);
            }
            
            if (i * 3 <= y) {
                arr[i * 3] = arr[i * 3] == 0 ? arr[i] + 1 : Math.min(arr[i * 3], arr[i] + 1);
            }
        }
    
        return arr[y] == f ? -1 : arr[y];
    }
}