import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        int answer = 0;
        for (String s : str) {
            Stack<Character> stack = new Stack<>();
            for (char x : s.toCharArray()) {
                if (stack.size() >= 1) {
                    if (stack.peek() == x) {
                        stack.pop();
                    } else {
                        stack.push(x);
                    }
                } else {
                    stack.push(x);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}