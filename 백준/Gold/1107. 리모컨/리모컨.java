import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] arr = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        if (n == 100) {
            System.out.println(0);
            return;
        }

        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(n - 100); // 모든 버튼이 고장난 상태에서 이동할 때
        // 주어지는 n의 최댓값은 50만이지만 0부터 따질수도, 100만부터 따질수도 있다.
        for (int i = 0; i <= 1_000_000; i++) {
            if (!isBroken(i)) {
                // 하나도 고장난 것이 없다면 -> 값을 저장
                answer = Math.min(answer, calc(i));
            }
        }

        System.out.println(answer);
    }

    // 눌러야 할 버튼 수 계산
    private static int calc(int num) {
        if (num == 0) {
            return Math.abs(n - num) + 1;
        }
        // 자릿수 + 차이값
        return (int) ((Math.log10(num) + 1) + Math.abs(n - num));
    }

    // num을 구성하는 숫자에 고장난 숫자들이 포함되어있는지 검사
    private static boolean isBroken(int num) {
        if (num == 0) {
            return arr[0];
        }

        while (num > 0) {
            int x = num % 10;
            if (arr[x]) {
                return true;
            }
            num /= 10;
        }

        return false;
    }
}