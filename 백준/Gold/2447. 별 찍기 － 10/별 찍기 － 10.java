import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        star(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void star(int x, int y, int n, boolean blank) {

        // 공백칸
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없음
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        /*
            n = 27 일 때, 한 블록의 크기는 9
            n = 9 일 때, 한 블록의 크기는 3
            한 블록의 변수 size
            count는 별 출력 누적
         */
        int size = n / 3;
        int count = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }

}