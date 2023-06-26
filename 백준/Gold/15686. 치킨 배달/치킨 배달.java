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
    static Point[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 1) {
                    house.add(new Point(i, j));
                } else if (num == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        selected = new Point[m];

        recursion(0, 0);

        System.out.println(answer);
    }

    public static void recursion(int depth, int index) {
        // 치킨집이 많을 수록 치킨 거리는 작아질 확률이 높음
        // 따라서 1부터 m까지가 아닌, m일때만을 계산
        if (depth == m) {
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    int dist = Math.abs(house.get(i).row - selected[j].row)
                            + Math.abs(house.get(i).col - selected[j].col);
                    tmp = Math.min(tmp, dist);
                }
                sum += tmp;
            }
            answer = Math.min(answer, sum);
            return;
        }

        if (index == chicken.size()) {
            return;
        }
        
        selected[depth] = chicken.get(index);
        recursion(depth + 1, index + 1);
        recursion(depth, index + 1);
    }
}