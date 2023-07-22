import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                answer.append(0).append(" ");
                stack.add(new Tower(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        answer.append(0).append(" ");
                        stack.add(new Tower(i, height));
                        break;
                    }

                    Tower top = stack.peek();

                    if (top.height < height) {
                        stack.pop();
                    } else {
                        answer.append(top.idx).append(" ");
                        stack.add(new Tower(i, height));
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}