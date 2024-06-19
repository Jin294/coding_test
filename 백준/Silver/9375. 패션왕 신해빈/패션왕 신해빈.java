import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            Map<String, Set<String>> map = new HashMap<>();
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();

                if (!map.containsKey(second)) {
                    map.put(second, new HashSet<>());
                }
                map.get(second).add(first);
            }
            int sum = 1;
            for (String key : map.keySet()) {
                sum *= map.get(key).size() + 1;
            }

            System.out.println(sum - 1);
        }
    }
}