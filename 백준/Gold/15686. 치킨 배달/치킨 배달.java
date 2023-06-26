import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class House {
        int row;
        int col;

        public House(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Chicken{
        int row;
        int col;
        int dist;

        public Chicken(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m;
    static int min = Integer.MAX_VALUE;
    static ArrayList<House> hList = new ArrayList<>();
    static ArrayList<Chicken> cList = new ArrayList<>();
    static boolean[] visited;
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
                    hList.add(new House(i, j));
                } else if (num == 2) {
                    cList.add(new Chicken(i, j));
                }
            }
        }

        visited = new boolean[cList.size()];

        for (int i = 1; i <= m; i++) {
            recursion(0, 0, i);
        };

        System.out.println(min);
    }

    public static void recursion(int depth, int count, int max) {
        if (depth <= cList.size() && count == max) {
            min = Math.min(min, getChickenDistance());
            return;
        }

        if (depth == cList.size()) {
            return;
        }

        recursion(depth + 1, count, max);
        visited[depth] = true;
        recursion(depth + 1, count + 1, max);
        visited[depth] = false;
    }

    public static int getChickenDistance(){
        int answer = 0;

        // 집에서 가장 가까운 치킨집 구하자
        for (int i = 0; i < hList.size(); i++) {
            House home = hList.get(i);

            int sum = 0;
            int dist =  1;
            out:while (true) {
                for (int j = 0; j < cList.size(); j++) {
                    if (visited[j]) {
                        if (Math.abs(cList.get(j).row - home.row)
                            + Math.abs(cList.get(j).col - home.col) == dist) {
                            sum += dist;
                            break out;
                        }
                    }
                }
                dist++;
            }
            answer += sum;
        }

        return answer;
    }
}