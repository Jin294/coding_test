import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            char x = arr[i];
            if (x == '(') {
                stack.push(x);
                value *= 2;
            } else if (x == '[') {
                stack.push(x);
                value *= 3;
            } else if (x == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                } else if (arr[i - 1] == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            } else if (x == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                } else if (arr[i - 1] == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}