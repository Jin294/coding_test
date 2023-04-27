import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            if (str[1].charAt(0) == 'e') {
                map.put(str[0], 1);
            } else {
                map.remove(str[0]);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            list.add(name);
        }

        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}