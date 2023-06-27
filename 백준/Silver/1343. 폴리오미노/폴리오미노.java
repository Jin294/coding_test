import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static StringBuilder dot = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X'){
                if (dot.length() > 0) {
                    answer.append(dot);
                    dot = new StringBuilder();
                }
                count++;
            } else {
                if (count > 0) {
                    count = goPolyomino(count);
                    if (count == -1) {
                        System.out.println(-1);
                        return;
                    }
                }
                dot.append(".");
            }
        }

        if (dot.length() > 0) {
            answer.append(dot);
        }

        if (count > 0) {
            if (goPolyomino(count) == -1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }

    private static int goPolyomino(int count) {
        // x개수가 홀수면 덮을 수 없다.
        if (count % 2 == 1) {
            return -1;
        }

        while (count / 4 > 0) {
            answer.append("AAAA");
            count -= 4;
        }

        while (count / 2 > 0) {
            answer.append("BB");
            count -= 2;
        }

        return 0;
    }
}