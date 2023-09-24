class Solution {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int row = -1, col = 0;
        while (n > 0) {
            // 맨 왼쪽줄
            for (int i = 0; i < n; i++) {
                matrix[++row][col]  = num++;
            }
            n--;

            // 맨 아랫줄
            for (int i = 0; i < n; i++) {
                matrix[row][++col] = num++;
            }
            n--;

            // 대각선 좌상
            for (int i = 0; i < n; i++) {
                matrix[--row][--col] = num++;
            }
            n--;
        }

        int idx = 0;
        int[] answer = new int[matrix.length * (matrix.length + 1) / 2];
        for (int[] rows : matrix) {
            for (int item : rows) {
                if (item == 0) {
                    break;
                }
                answer[idx++] = item;
            }
        }
        return answer;
    }
}