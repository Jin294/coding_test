import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static boolean hasMin, hasMax;
    static char[] inequal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] maxArr = new int[n + 1];
        int[] minArr = new int[n + 1];
        Arrays.fill(maxArr, -1);
        Arrays.fill(minArr, -1);

        // 0부터 9까지의 수를 한 번만 쓸 수 있다.
        boolean[] maxCounts = new boolean[10];
        boolean[] minCounts = new boolean[10];

        // 한줄로 받아 배열로 자동쪼개기
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequal = new char[n];
        for (int i = 0; i < n; i++) {
            inequal[i] = st.nextToken().charAt(0);
        }

        goMax(0, maxArr, maxCounts);
        goMin(0, minArr, minCounts);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxArr.length; i++) {
            sb.append(maxArr[i]);
        }
        sb.append("\n");
        for (int i = 0; i < minArr.length; i++) {
            sb.append(minArr[i]);
        }
        System.out.println(sb);
    }

    private static void goMax(int depth, int[] maxArr, boolean[] maxCounts) {
        if (depth == n + 1) {
            if (check(maxArr)) {
                hasMax = true;
            }
            return;
        }

        if (hasMax) {
            return;
        }

        for (int i = 9; i >= 0; i--) {
            // 숫자를 사용한 적이 없으면
            if (!maxCounts[i] && !hasMax) {
                maxCounts[i] = true;
                maxArr[depth] = i;
                goMax(depth + 1, maxArr, maxCounts);
                maxCounts[i] = false;
            }
        }

    }

    private static void goMin(int depth, int[] minArr, boolean[] minCounts) {
        if (depth == n + 1) {
            if (check(minArr)) {
                hasMin = true;
            }
            return;
        }

        if (hasMin) {
            return;
        }

        for (int i = 0; i <= 9; i++) {
            // 숫자를 사용한 적이 없으면
            if (!minCounts[i] && !hasMin) {
                minCounts[i] = true;
                minArr[depth] = i;
                goMin(depth + 1, minArr, minCounts);
                minCounts[i] = false;
            }
        }

    }

    private static boolean check(int[] arr) {
        for (int i = 0; i < inequal.length; i++) {
            if (inequal[i] == '<') {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            } else { // '>'
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

}