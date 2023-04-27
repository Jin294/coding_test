import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] arr = new int[t][2];
        int max = 0;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
            max = max > arr[i][1] ? max : arr[i][1];
        }

        BigInteger[] tmp = new BigInteger[max + 1];
        tmp[1] = new BigInteger("1");
        for (int i = 2; i <= max ; i++) {
            tmp[i] = tmp[i - 1].multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = 0; i < t; i++) {
            if (arr[i][0] == arr[i][1]) {
                System.out.println(1);
            } else {
                System.out.println(tmp[arr[i][1]].divide(tmp[arr[i][0]].multiply(tmp[arr[i][1] - arr[i][0]])));
            }
        }
    }

}