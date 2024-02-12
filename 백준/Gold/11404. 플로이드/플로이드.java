import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점 수 V와 간선 수 E
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        // 정점 개수만큼 인접행렬 생성 및 최댓값으로 초기화
        int[][] matrix = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                matrix[i][j] = (i == j) ? 0 : MAX;
            }
        }

        // 인접행렬에 노선 데이터 삽입
        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // from에서 to까지 도달하는데 value의 비용이 소요된다
            matrix[from][to] = Math.min(matrix[from][to], value);
        }

        // 플로이드 워셜
        // k : 경유지
        for (int k = 1; k <= V; k++) {
            // i : 시작지
            for (int i = 1; i <= V; i++) {
                // j : 도착지
                for (int j = 1; j <= V; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                sb.append(matrix[i][j] == MAX ? "0 " : matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}