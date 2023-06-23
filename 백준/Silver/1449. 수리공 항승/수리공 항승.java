import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        boolean[] counts = new boolean[1001];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(input[i])] = true;
        }

        int answer = 0;
        for (int i = 1; i <= 1000; i++) {
            if (counts[i]) {
                answer++;
                i += l - 1;
            }
        }
        System.out.println(answer);
    }
}