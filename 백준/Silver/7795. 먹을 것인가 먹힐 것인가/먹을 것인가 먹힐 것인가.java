import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] nArr = new int[n];
            int[] mArr = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < nArr.length; i++) {
                nArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < mArr.length; i++) {
                mArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nArr);
            Arrays.sort(mArr);
            int answer = 0;
            for (int i = n - 1; i > -1; i--) {
                for (int j = 0; j < m; j++) {
                    if (nArr[i] > mArr[j]) {
                        answer++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}