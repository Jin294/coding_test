import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;

    static int n;
    static final int X = 0;
    static final int S = 1;
    static final int T = 2;
    static final int O = 3;
    
    static ArrayList<int[]> blanks = new ArrayList<>();

    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};
    
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix  = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                char x = st.nextToken().charAt(0);
                if (x == 'S') {
                    matrix[i][j] = S;
                } else if (x == 'T') {
                    matrix[i][j] = T;
                } else {
                    blanks.add(new int[]{i, j});
                    matrix[i][j] = X;
                }
            }
        }

        setBlanks(0, 0);

        System.out.println(flag ? "YES" : "NO");
    }

    public static void setBlanks(int depth, int idx) {
        if (depth == 3) {
            // 점호 시작~~
            if (checkStudents()) {
                flag = true;
            }
            return;
        }

        for (int i = idx; i < blanks.size(); i++) {
            int[] now = blanks.get(i);
            matrix[now[0]][now[1]] = O;
            setBlanks(depth + 1, i + 1);
            matrix[now[0]][now[1]] = X;
        }
    }

    public static boolean checkStudents() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 선생님 계신가요
                if (matrix[i][j] == T) {
                    // 학생들 체크 좀 해주세요
                    if (!checkStraight(i, j)) {
                        // 잡았다 요놈~
                        return false;
                    }
                }
            }
        }

        // 점호 끝~~
        return true;
    }

    public static boolean checkStraight(int row, int col) {
        // 즐거운 점호시간~
        for (int i = 0; i < 4; i++) {
            int idx = 1;
            int nr = row + moveY[i] * idx;
            int nc = col + moveX[i] * idx;
            
            while (isRangeIn(nr, nc)) {
                // 요깄네~
                if (matrix[nr][nc] == S) {
                    return false;
                }

                // 이쪽은 가려져서 더 안봐도 되겠지~
                if (matrix[nr][nc] == O) {
                    break;
                }

                idx++;
                nr = row + moveY[i] * idx;
                nc = col + moveX[i] * idx;
            }
        }

        // 어휴, 애들이 어디숨은거야~
        return true;
    }

    public static boolean isRangeIn(int row, int col) {
        return row >=0 && col >= 0 && row < n && col < n;
    }
}