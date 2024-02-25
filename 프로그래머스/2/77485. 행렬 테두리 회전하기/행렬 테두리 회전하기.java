import java.util.*;

class Solution {
    int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + (j + 1);
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = getMinRotateClockwise(queries[i]);
        }
        
        return answer;
    }
    
    public int getMinRotateClockwise(int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;
        
        int min = matrix[r1][c1];
        int save = matrix[r1][c1]; // 오리지널 r1, c1의 값
        
        // 시계방향이면, 거꾸로 반시계방향으로 거슬러 올라가야 한다.
        // 왼쪽이 위로 올라온다 => r1, c1부터 내려가야 한다.
        for (int i = r1; i < r2; i++) {
            min = Math.min(matrix[i][c1], min);
            matrix[i][c1] = matrix[i + 1][c1];
        }
        
        // 바닥이 왼쪽으로 이동한다. => r2, c1부터 오른쪽으로
        for (int i = c1; i < c2; i++) {
            min = Math.min(matrix[r2][i], min);
            matrix[r2][i] = matrix[r2][i + 1];
        }
                
        // 오른쪽이 아래로 내려간다 => r2, c2부터 올라간다
        for (int i = r2; i > r1; i--) {
            min = Math.min(matrix[i][c2], min);
            matrix[i][c2] = matrix[i - 1][c2];
        }
        
        int tmp = matrix[r1][c1]; // 왼쪽이 위로 올라오면서, 오리지널의 한 칸 아래값이 저장됨
        matrix[r1][c1] = save;
        
        // 천장이 오른쪽으로 이동한다 => r1, c2부터 왼쪽으로
        for (int i = c2; i > c1; i--) {
            min = Math.min(matrix[r1][i], min);
            matrix[r1][i] = matrix[r1][i - 1];
        }
        
        matrix[r1][c1] = tmp;
                
        return min;
    }
}