import java.util.*;
import java.io.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        // 데이터 입력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            arr = br.readLine().toCharArray();
        };

        // 카운팅정렬(계수정렬)
        int[] counts = new int[26];
        for (char x : arr) {
            counts[x - 'A']++;
        }

        // 홀수개가 두개 이상인지 체크
        boolean isOdd = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                if (isOdd) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                isOdd = true;
                sb.append((char)('A' + i));
                counts[i]--;
            }
        }

        // 펠린드롬 만들기
        for (int i = 25; i >= 0; i--) {
            while (counts[i] > 0) {
                char x = (char) ('A' + i);
                sb.insert(0, x);
                sb.append(x);
                counts[i] -= 2;
            }
        }
        System.out.println(sb);
    }
}