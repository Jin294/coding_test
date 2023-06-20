import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, d;
    // 순서 : 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    // 0 : 북, 1 : 동, 2 : 남, 3 : 서
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        out : while (true) {
            // 현재 칸이 청소되지 않은 경우
            if (matrix[r][c] == 0) {
                matrix[r][c] = 2;
                count++;
            } else { // 현재 칸은 청소된경우
                // 주변의 상하좌우 4칸 중 청소되지 않은 칸이 없다면
                if (isCleanUpAround(r, c)) {
                    if (canGoBackward(r, c, d)) {
                        r -= dy[d];
                        c -= dx[d];

                        // 후진했는데 벽이면 작동 중지
                        if (matrix[r][c] == 1) {
                            break out;
                        }
                    }
                } else { // 주변에 청소할 칸이 남아있다면
                    // 반시계 방향 90도 회전
                    d = (d + 3) % 4;
                    if (canGoForward(r, c, d)) {
                        r += dy[d];
                        c += dx[d];
                    }
                }
            }
        }
        System.out.println(count);
    }

    // 한 칸 후진
    private static boolean canGoBackward(int r, int c, int d) {
        int nr = r - dy[d];
        int nc = c - dx[d];

        // 범위를 벗어난 경우 후진 중단
        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
            return false;
        }

         return true;
    }

    // 한 칸 전진
    private static boolean canGoForward(int r, int c, int d) {
        int nr = r + dy[d];
        int nc = c + dx[d];

        // 범위를 벗어난 경우 전진 불가
        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
            return false;
        }

        // 앞쪽 칸이 벽(1) 또는 청소된 곳(2)이면 전진 중단
        if (matrix[nr][nc] >= 1) {
            return false;
        }

        return true;
    }

    // 주변에 청소가 다 되어서 청소할 칸이 없니?
    private static boolean isCleanUpAround(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }

            // 청소할 칸이 있다면
            if (matrix[nr][nc] == 0) {
                return false;
            }
        }

        // 네 없어요 깨끗해요
        return true;
    }

    private static boolean isAllCleaned(int r, int c) {
        // 현재 위치와 주변 상하좌우가 전부 깨끗한 상태
        if (isCleanUpAround(r, c) && matrix[r][c] == 2) {
            return true;
        }

        return false;
    }
}