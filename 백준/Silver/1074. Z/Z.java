import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        recursion(size, r, c);
        System.out.println(answer);
    }

    private static void recursion(int n, int r, int c) {
        if (n == 1) {
            return;
        }

        int newSize = n /= 2;

        if (r < newSize && c < newSize) {
            recursion(newSize, r, c);
        } else if (r < newSize) {
            answer += newSize * newSize;
            recursion(newSize, r, c - newSize);
        } else if (c < newSize) {
            answer += newSize * newSize * 2;
            recursion(newSize, r - newSize, c);
        } else {
            answer += newSize * newSize * 3;
            recursion(newSize, r - newSize, c - newSize);
        }
    }
}