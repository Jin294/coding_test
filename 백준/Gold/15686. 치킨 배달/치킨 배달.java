import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static boolean[] selected;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 1) {
                    house.add(new Point(i, j));
                } else if (num == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        selected = new boolean[chicken.size()];

        recursion(0, 0);

        System.out.println(answer);
    }

    public static void recursion(int index, int count) {
        // 치킨집이 많을 수록 치킨 거리는 작아질 확률이 높음
        // 따라서 1부터 m까지가 아닌, m일때만을 계산
        if (count == m) {
            int result = 0;

            for (int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (selected[j]) {
                        int dist = Math.abs(house.get(i).row - chicken.get(j).row)
                                + Math.abs(house.get(i).col - chicken.get(j).col);
                        tmp = Math.min(tmp, dist);
                    }
                }
                result += tmp;
            }
            answer = Math.min(result, answer);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            selected[i] = true;
            recursion(i + 1, count + 1);
            selected[i] = false;
        }
    }
}