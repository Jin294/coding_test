import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(int depth, int sum) {
        if (depth == n) {
            max = max > sum ? max : sum;
            min = min > sum ? sum : min;
            return;
        }

        if (operators[0] > 0) {
            operators[0]--;
            recursion(depth + 1, sum + nums[depth]);
            operators[0]++;
        }

        if (operators[1] > 0) {
            operators[1]--;
            recursion(depth + 1, sum - nums[depth]);
            operators[1]++;
        }

        if (operators[2] > 0) {
            operators[2]--;
            recursion(depth + 1, sum * nums[depth]);
            operators[2]++;
        }

        if (operators[3] > 0) {
            operators[3]--;
            recursion(depth + 1, sum / nums[depth]);
            operators[3]++;
        }
    }

}