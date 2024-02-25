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
            answer[i] = rotateClockwiseAndGetMin(queries[i]);
        }
        
        return answer;
    }
    
    public int rotateClockwiseAndGetMin(int[] query) {
        int startRow = query[0] - 1;
        int startCol = query[1] - 1;
        int endRow = query[2] - 1;
        int endCol = query[3] - 1;
        
        int minValue = matrix[startRow][startCol];
        int originalValue = matrix[startRow][startCol]; 
        
        for (int i = startRow; i < endRow; i++) {
            minValue = Math.min(matrix[i][startCol], minValue);
            matrix[i][startCol] = matrix[i + 1][startCol];
        }
        
        for (int i = startCol; i < endCol; i++) {
            minValue = Math.min(matrix[endRow][i], minValue);
            matrix[endRow][i] = matrix[endRow][i + 1];
        }
                
        for (int i = endRow; i > startRow; i--) {
            minValue = Math.min(matrix[i][endCol], minValue);
            matrix[i][endCol] = matrix[i - 1][endCol];
        }
        
        int lastValue = matrix[startRow][startCol];
        matrix[startRow][startCol] = originalValue;
        
        for (int i = endCol; i > startCol; i--) {
            minValue = Math.min(matrix[startRow][i], minValue);
            matrix[startRow][i] = matrix[startRow][i - 1];
        }
        
        matrix[startRow][startCol] = lastValue;
                
        return minValue;
    }
}
