import java.io.*;
import java.util.*;

public class Main {
    // 방향에 숫자 연결
    static final int RIGHT = 0;
    static final int UP = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;
    static final int LENGTH = 101;

    static boolean[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        matrix = new boolean[LENGTH][LENGTH];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            // 방향 저장
            List<Integer> directions = getDirections(d, g);

            // 그리기
            drawCurves(row, col, directions);
        }

        // 사각형 숫자 세기
        System.out.println(countSquare());
    }

    public static boolean isSquare(int row, int col) {
        return matrix[row][col] && matrix[row + 1][col] && matrix[row][col + 1] && matrix[row + 1][col + 1];
    }

    public static int countSquare(){
        int count = 0;

        for (int i = 0; i < LENGTH - 1; i++) {
            for (int j = 0; j < LENGTH - 1; j++) {
                if (isSquare(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void drawCurves(int row, int col, List<Integer> directions) {
        matrix[row][col] = true;

        for (int d : directions) {
            switch (d) {
                case RIGHT:
                    matrix[row][++col] = true;
                    break;
                case UP:
                    matrix[--row][col] = true;
                    break;
                case LEFT:
                    matrix[row][--col] = true;
                    break;
                case DOWN:
                    matrix[++row][col] = true;
                    break;
            }
        }

    }

    public static List<Integer> getDirections(int d, int g) {
        List<Integer> result = new ArrayList<>();
        result.add(d);

        for (int i = 0; i < g; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                int nextDirection = (result.get(j) + 1) % 4;
                result.add(nextDirection);
            }
        }

        return result;
    }
}