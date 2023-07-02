import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < w - 1; i++) { // 처음과 마지막 제외
            int lt = 0;
            int rt = 0;
            for (int j = 0; j < i; j++) {
                lt = Math.max(lt, arr[j]);
            }
            for (int j = i + 1; j < w; j++) {
                rt = Math.max(rt, arr[j]);
            }

            if (arr[i] < lt && arr[i] < rt) {
                answer += (Math.min(lt, rt)) - arr[i];
            }
        }

        System.out.println(answer);
    }
}