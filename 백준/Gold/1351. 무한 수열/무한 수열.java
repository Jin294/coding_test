import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int p, q;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        System.out.println(solution(n));
    }

    private static long solution(long num) {
        if (num == 0) return 1L;
        if (!map.containsKey(num / p)) map.put(num / p, solution(num / p));
        if (!map.containsKey(num / q)) map.put(num / q, solution(num / q));
        return map.get(num / p) + map.get(num / q);
    }
}