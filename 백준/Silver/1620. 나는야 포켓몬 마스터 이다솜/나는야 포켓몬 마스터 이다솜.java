import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> names2Nums = new HashMap<>();
        HashMap<String, String> nums2Names = new HashMap<>();
        // 데이터 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            names2Nums.put(s, String.valueOf(i));
            nums2Names.put(String.valueOf(i), s);
        }

        // 데이터 찾기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (names2Nums.containsKey(s)) { // 찾고자 하는 value 가 문자일때
                sb.append(names2Nums.get(s)).append("\n");
            } else { //s가 숫자일 때
                sb.append(nums2Names.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}