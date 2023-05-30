import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        double count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            count++;
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
            sb.append(String.format("%.4f", map.get(list.get(i)) * 100 / count));
            sb.append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
}