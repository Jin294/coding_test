import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, s, count;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        count = 0;
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        if (s == 0) {
            count--;
        }
        recursion(0, 0);
        System.out.println(count);
    }

    private static void recursion(int sum, int idx) {
        if (idx == n) {
            if (sum == s) {
                count++;
            }
            return;
        }


        recursion(sum + list.get(idx), idx + 1);
        recursion(sum, idx + 1);
    }
}