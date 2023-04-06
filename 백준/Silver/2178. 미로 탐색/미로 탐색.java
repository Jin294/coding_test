import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int y;
    int x;
    int depth;

    public Node(int y, int x, int depth) {
        this.y = y;
        this.x = x;
        this.depth = depth;
    }
}

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    board[i][j] = 1;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        
        // 메인 알고리즘
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int row = cur.y;
            int col = cur.x;

            // 목적지에 도달했을 때
            if (row == n - 1 && col == m - 1) {
                list.add(cur.depth);
                continue;
            }

            // 상하좌우 갈 수 있는 칸을 큐에 넣기
            for (int i = 0; i < 4; i++) {
                int x = col + dx[i];
                int y = row + dy[i];

                // 이동할 수 있는 칸 && 방문한 적 없으면 큐에 넣는다.
                if ((y > -1 && y < n && x > -1 && x < m) && board[y][x] == 1&& !visited[y][x]) {
                    visited[y][x] = true;
                    queue.add(new Node(y, x, cur.depth + 1));
                }
            }
        }

        // 여러 경로로 도달 가능하다면 최솟값을 취한다
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
