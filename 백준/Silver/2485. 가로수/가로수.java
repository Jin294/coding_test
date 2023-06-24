import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] diff = new int[n - 1];
        arr[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            diff[i - 1] = arr[i] - arr[i - 1];
        }

        // 최대공약수 계산
        int gcd = diff[0];
        for (int i = 0; i < diff.length; i++) {
            gcd = getGCD(diff[i], gcd);
        }

        // 최종 계산
        int answer = 0;
        for (int i = 0; i < diff.length; i++) {
            answer += (diff[i] / gcd) - 1;
        }
        System.out.println(answer);
    }

    private static int getGCD(int num, int div) {
        int remain = num % div;
        if (remain == 0) {
            return div;
        } else {
            return getGCD(div, remain);
        }
    }
}