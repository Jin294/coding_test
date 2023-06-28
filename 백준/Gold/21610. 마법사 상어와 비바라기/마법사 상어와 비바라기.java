import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Cloud {
        int row;
        int col;

        public Cloud(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Move {
        int di;
        int si;

        public Move(int di, int si) {
            this.di = di;
            this.si = si;
        }
    }

    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int n, m;
    // 0, ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static Move[] moves;
    static int[][] matrix;
    static boolean[][] visited;
    static Queue<Cloud> q = new LinkedList<>();
    static Queue<Point> points = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동정보
        moves = new Move[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i] = new Move(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        // 0. 처음 비바라기 시전 -> 구름 생긴다
        q.add(new Cloud(n - 1, 0));
        q.add(new Cloud(n - 1, 1));
        q.add(new Cloud(n - 2, 0));
        q.add(new Cloud(n - 2, 1));

        // m번동안 이동
        for (int i = 0; i < m; i++) {
            visited = new boolean[n][n];
            while (!q.isEmpty()) {
                Cloud target = q.poll();

                int newRow = target.row + dy[moves[i].di] * moves[i].si;
                int newCol = target.col + dx[moves[i].di] * moves[i].si;

                newRow = merryGoRound(newRow);
                newCol = merryGoRound(newCol);

                // 비가 내려서 구름이 있는 칸의 물의 양이 증가한다
                matrix[newRow][newCol]++;

                // 구름이 사라진 칸 == 물의 양이 증가한 칸 체크
                visited[newRow][newCol] = true;

                // 물복사 버그 위해 좌표 저장
                points.add(new Point(newRow, newCol));
            }

            // 구름이 모두 사라진 후
            while (!points.isEmpty()) {
                // 물 복사 버그
                // 물이 증가한 칸에 물 복사 버그
                Point target = points.poll();

                // 대각선 방향 거리가 1인 칸에 있는 물만큼 원칸에 물 양 증가
                for (int j = 2; j <= 8; j += 2) {
                    int newRow = target.row + dy[j];
                    int newCol = target.col + dx[j];

                    if (isRanged(newRow, newCol) && matrix[newRow][newCol] > 0) {
                        matrix[target.row][target.col]++;
                    }
                }
            }

            formCloud();
        }

        System.out.println(getTotalWater());
    }

    static boolean isRanged(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }
        return true;
    }

    static void formCloud(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= 2 && !visited[i][j]) {
                    q.add(new Cloud(i, j));
                    matrix[i][j] -= 2;
                }
            }
        }
    }

    static int getTotalWater(){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    static int merryGoRound(int now){
        while (now >= n) {
            now -= n;
        }

        while (now < 0) {
            now += n;
        }

        return now;
    }
}