import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = map.get(st.nextToken().charAt(0));
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);

            if (lt != '.') {
                max = max < idx * 2 ? idx * 2 : max;
                map.put(lt, idx * 2);
            }

            if (rt != '.') {
                max = max < idx * 2 + 1 ? idx * 2 + 1 : max;
                map.put(rt, idx * 2 + 1);
            }
        }

        arr = new char[max + 1];
        for (int i = 0; i < n; i++) {
            char item = (char) ('A' + i);
            arr[map.get(item)] = item;
        }

        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);

        System.out.println(sb);
    }

    private static void preOrder(int now) {
        if (now >= arr.length) {
            return;
        }

        if (!Character.isAlphabetic(arr[now])) {
            return;
        }

        sb.append(arr[now]);

        preOrder(now * 2);

        preOrder(now * 2 + 1);
    }

    private static void inOrder(int now) {
        if (now >= arr.length) {
            return;
        }

        if (!Character.isAlphabetic(arr[now])) {
            return;
        }

        inOrder(now * 2);

        sb.append(arr[now]);

        inOrder(now * 2 + 1);
    }

    private static void postOrder(int now) {
        if (now >= arr.length) {
            return;
        }

        if (!Character.isAlphabetic(arr[now])) {
            return;
        }

        postOrder(now * 2);

        postOrder(now * 2 + 1);

        sb.append(arr[now]);
    }
}