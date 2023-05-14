import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        ArrayList<Integer> table = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            table.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < k - 1; i++) {
            map.put(table.get(i), map.getOrDefault(table.get(i), 0) + 1);
        }

        int lt = 0;
        int rt = k - 1;
        int count = 0;
        while (count < n) {
            int in = table.get(rt % n);
            map.put(in, map.getOrDefault(in, 0) + 1);
            rt++;
            int size = map.size();
            if (!map.containsKey(c)) {
                size++;
            }

            answer = answer > size ? answer : size;

            int out = table.get(lt % n);
            map.put(out, map.getOrDefault(out, 0) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }
            lt++;
            count++;
        }

        System.out.println(answer);
    }
}