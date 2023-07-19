import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int n, m, answer;
    static Point[] choice;
    static boolean[] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static ArrayList<Point> spaceList = new ArrayList<>();
    static Queue<Point> virusList = new LinkedList<>();
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 0) {
                    spaceList.add(new Point(i, j));
                    count++;
                } else if (matrix[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        choice = new Point[3];
        visited = new boolean[count];

        getThree(0);

        System.out.println(answer);
    }

    private static void getThree(int depth) {
        if (depth == 3) {
            go();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[depth] = spaceList.get(i);
                getThree(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void go() {
        // 벽 세우기
        for (int i = 0; i < 3; i++) {
            matrix[choice[i].row][choice[i].col] = 1;
        }

        // 바이러스가 퍼지고 안전지대 찾기
        answer = Math.max(answer, chaos());

        // 세운 벽 허물기
        for (int i = 0; i < 3; i++) {
            matrix[choice[i].row][choice[i].col] = 0;
        }
    }

    private static int chaos() {
        boolean[][] isEmpty = new boolean[n][m];
        int[][] board = new int[n][m];

        // board에 matrix를 복사
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.copyOf(matrix[i], m);
        }

        // 상하좌우 바이러스 퍼뜨리기
        Queue<Point> nowVirus = new LinkedList<>(virusList);
        while (!nowVirus.isEmpty()) {
            Point virus = nowVirus.poll();

            if (!isEmpty[virus.row][virus.col]) {
                for (int i = 0; i < 4; i++) {
                    int nr = virus.row + dy[i];
                    int nc = virus.col + dx[i];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (board[nr][nc] == 0) {
                            board[nr][nc] = 2;
                            nowVirus.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }

        // 굳이 이차원배열 전체를 탐색할 필요 없이
        // 빈 공간만 바이러스에 감염된 여부를 체크해주면 된다.
        int count = 0;
        for (int i = 0; i < spaceList.size(); i++) {
            if (board[spaceList.get(i).row][spaceList.get(i).col] == 0) {
                count++;
            }
        }

        return count;
    }

}