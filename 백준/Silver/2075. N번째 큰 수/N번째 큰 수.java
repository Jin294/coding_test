import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Integer.valueOf(st.nextToken()));
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        int count = 0;
        for (int num : list) {
            count++;
            if (count == n) {
                System.out.println(num);
                break;
            }
        }
    }
}