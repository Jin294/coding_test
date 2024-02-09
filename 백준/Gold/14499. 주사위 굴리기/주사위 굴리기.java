import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] matrix;
    static int n, m;
    static int[] moveY = {0, 0, -1, 1};
    static int[] moveX = {1, -1, 0, 0};
    static int[] dice = new int[7];
    static final int TOP = 1, REAR = 2, RIGHT = 3, LEFT = 4, FRONT = 5, BOTTOM = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로
        int x = Integer.parseInt(st.nextToken()); // 세로축 이동변수
        int y = Integer.parseInt(st.nextToken()); // 가로축 이동변수
        int k = Integer.parseInt(st.nextToken()); // 명령의개수

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());

            // 이동
            int nr = x + moveY[d - 1];
            int nc = y + moveX[d - 1];

            // 범위 체크
            if (!isRangeIn(nr, nc)) {
                continue;
            }

            // move
            x = nr;
            y = nc;

            // 주사위 굴리기
            rollDice(x, y, d);

            // 상단 출력
            System.out.println(dice[TOP]);
        }
    }

    public static boolean isRangeIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void rollDice(int row, int col, int d) {
        switch (d) {
            case 1: // 오른쪽으로 굴리기
                int tempRight = dice[RIGHT];
                dice[RIGHT] = dice[BOTTOM];
                dice[BOTTOM] = dice[LEFT];
                dice[LEFT] = dice[TOP];
                dice[TOP] = tempRight;
                break;
            case 2: // 왼쪽으로 굴리기
                int tempLeft = dice[LEFT];
                dice[LEFT] = dice[BOTTOM];
                dice[BOTTOM] = dice[RIGHT];
                dice[RIGHT] = dice[TOP];
                dice[TOP] = tempLeft;
                break;
            case 3: // 위로 굴리기
                int tempTop = dice[TOP];
                dice[TOP] = dice[REAR];
                dice[REAR] = dice[BOTTOM];
                dice[BOTTOM] = dice[FRONT];
                dice[FRONT] = tempTop;
                break;
            case 4: // 아래로 굴리기
                int tempBottom = dice[BOTTOM];
                dice[BOTTOM] = dice[REAR];
                dice[REAR] = dice[TOP];
                dice[TOP] = dice[FRONT];
                dice[FRONT] = tempBottom;
                break;
        }

        if (matrix[row][col] != 0) {
            // 지도칸이 0이 아니면 지도칸의 수가 주사위 바닥으로 복사됨
            dice[BOTTOM] = matrix[row][col];

            // 지도칸은 0이 된다
            matrix[row][col] = 0;
        } else {
            // 지도칸이 0이면 주사위의 수가 복사됨
            matrix[row][col] = dice[BOTTOM];
        }
    }
}