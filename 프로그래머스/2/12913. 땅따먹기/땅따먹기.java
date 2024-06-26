import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] matrix = new int[n][4];
        
        for (int i = 0; i < 4; i++) {
            matrix[0][i] = land[0][i];
        }
        
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < 4; col++) {
                for (int idx = 0; idx < 4; idx++) {
                    if (col == idx) continue;
                    
                    matrix[row][col] = Math.max(matrix[row][col], matrix[row - 1][idx] + land[row][col]);
                }
            }
        }
        
        return Arrays.stream(matrix[n - 1]).max().getAsInt();
    }
}