import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int y;
        int x;
        int val;
        int d;

        public Point(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    static int n, m;
    static int answer  = Integer.MAX_VALUE;
    // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Point[] cameras;
    static int[][] matrix;
    static ArrayList<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] >= 1 && matrix[i][j] <= 5) {
                    list.add(new Point(i, j, matrix[i][j]));
                }
            }
        }

        cameras = new Point[list.size()];
        for (int i = 0; i < list.size(); i++) {
            cameras[i] = list.get(i);
        }

        solution(0);
        System.out.println(answer);
    }

    private static void solution(int idx) {
        if (idx == cameras.length) {
            checkSight();
            return;
        }

        setDirection(idx);
    }

    private static void checkSight() {
        // 배열 복사
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = matrix[i].clone();
        }

        // 감시범위 표시
        for (int i = 0; i < cameras.length; i++) {
            Point target = cameras[i];
            getDirections(copy, target.y, target.x, target.val, target.d);
        }

        // 사각지대 체크
        answer = Math.min(answer, countZero(copy));
    }

    private static void setDirection(int idx){
        Point target = list.get(idx);
        switch (target.val) {
            case 2:
                for (int i = 0; i < 2; i++) {
                    cameras[idx].d = i;
                    solution(idx + 1);
                }
                break;
            case 5:
                cameras[idx].d = 0;
                solution(idx + 1);
                break;
            default:
                for (int i = 0; i < 4; i++) {
                    cameras[idx].d = i;
                    solution(idx + 1);
                }
                break;
        }
    }

    private static void getDirections(int[][] copy, int y, int x, int val, int d) {
        getSingleDirection(copy, y, x, d);

        if (val >= 4) {
            getSingleDirection(copy, y, x, d + 1);
            getSingleDirection(copy, y, x, d + 2);
        } else if (val == 3) {
            getSingleDirection(copy, y, x, d + 1);
        } else if (val == 2)    {
            getSingleDirection(copy, y, x, d + 2);
        }

        if (val == 5) {
            getSingleDirection(copy, y, x, d + 3);
        }
    }

    // 한 방향으로
    private static void getSingleDirection(int[][] copy, int row, int col, int direction){
        int idx = 1;
        while (true) {
            int ny = row + dy[direction % 4] * idx;
            int nx = col + dx[direction % 4] * idx;

            if (isIn(ny, nx)){
                if (copy[ny][nx] == 0) {
                    copy[ny][nx] = -1;
                } else if (copy[ny][nx] == 6) {
                    break;
                }
            } else {
                break;
            }

            idx++;
        }
    }

    // 이차원 배열의 범위 안에 포함되는지
    private static boolean isIn(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < n && nx < m;
    }

    // 사각지대 개수세기
    private static int countZero(int[][] copy) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}