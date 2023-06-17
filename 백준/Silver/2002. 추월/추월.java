import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] before = new String[n];
        String[] after = new String[n];
        boolean[] check = new boolean[n];
        // 들어간 순서대로 출력
        for (int i = 0; i < n; i++) {
            before[i] = br.readLine();
        }
        // 나온 순서대로 출력
        for (int i = 0; i < n; i++) {
            after[i] = br.readLine();
        }

        int count = 0;

        // 추월 차량의 개수 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 자기 자신과 만나기 전의 차량들은 자신을 추월한 것
                // 차량 번호가 다르다면
                if (!before[i].equals(after[j])) {
                    // 검사하지 않았을 때
                    if (!check[j]) {
                        check[j] = true;
                        count++;
                    }
                } else { // 차량 번호가 같다면
                    check[j] = true;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}