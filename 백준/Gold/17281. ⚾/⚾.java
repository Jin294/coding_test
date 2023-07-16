import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[] lineUp; // 선수 순서의 배열 (인덱스와 무관)
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][10];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 1번 타자를 미리 배정한다.
        lineUp = new int[10];
        lineUp[4] = 1; // 4번째 선수는 1번 타자
        visited = new boolean[10];
        visited[4] = true; // 4번 자리는 이미 차있으므로 체크
        recursion(2); // 1번 선수는 이미 자리가 정해졌기에 2번 선수부터
        System.out.println(answer);
    }

    // 2. 선수 순서를 정한다.
    private static void recursion(int player) {
        // 선수 배정이 완료되었으면 종료
        if (player == 10) {
            answer = Math.max(answer, playBaseball());
            return;
        }

        // 선수를 1번자리부터 9번자리까지 넣으며 재귀 호출
        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lineUp[i] = player;
                recursion(player + 1);
                visited[i] = false;
            }
        }
    }

    // 3. 순서에 맞게 점수계산하며 최대점수 경신
    private static int playBaseball() {
        int sum = 0;
        int idx = 1;
        for (int inning = 0; inning < n; inning++) {
            int out = 0;
            int bases = 0;
            int inningScore = 0;
            while (out < 3) {
                int hit = matrix[inning][lineUp[idx++]];
                if (hit == 0) {
                    out++;
                } else {
                    bases = (bases + 1) << hit;
                    inningScore += Integer.bitCount(bases / 16);
                    bases = bases % 16;
                }

                if (idx >= 10) {
                    idx = 1;
                }
            }

            sum += inningScore;
        }

        return sum;
    }
}