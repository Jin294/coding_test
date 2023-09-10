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

        map.put(0L, 1L);

        solution(n);
        System.out.println(map.get(n));
    }

    private static long solution(long num) {
        if (num == 0) return map.get(num);

        if (!map.containsKey(num)) map.put(num, solution(num / p) + solution(num / q));
        return map.get(num);
    }
}