import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] nums, op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        op = new int[4];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, nums[0], 0, 0, 0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(int depth, int sum, int plus, int sub, int multi, int div) {
        if (depth == n) {
            max = max > sum ? max : sum;
            min = min > sum ? sum : min;
            return;
        }

        if (plus < op[0]) {
            recursion(depth + 1, sum + nums[depth], plus + 1, sub, multi, div);
        }

        if (sub < op[1]) {
            recursion(depth + 1, sum - nums[depth], plus, sub + 1, multi, div);
        }

        if (multi < op[2]) {
            recursion(depth + 1, sum * nums[depth], plus, sub, multi + 1, div);
        }

        if (div < op[3]) {
            recursion(depth + 1, sum / nums[depth], plus, sub, multi, div + 1);
        }
    }

}