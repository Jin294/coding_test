import java.util.HashSet;

class Solution {
    static int n, max;
    static char[] arr;
    static int[] answer;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb;

    public int solution(String numbers) {
        arr = numbers.toCharArray();
        n = arr.length;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n];
            answer = new int[i];
            recursion(0, i);
        }

        int count = 0;
        for (Integer item : set) {
            boolean isPrime = true;
            if (item <= 1) {
                continue;
            }
            for (int i = 2; i <= Math.sqrt(item); i++) {
                if (item % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        return count;
    }

    public void recursion(int depth, int len){
        if (depth == len) {
            sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(answer[i]);
            }
            int tmp = Integer.parseInt(sb.toString());
            set.add(tmp);
            max = Math.max(max, tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i] - '0';
                recursion(depth + 1, len);
                visited[i] = false;
            }
        }
    }
}