import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ss = 0;
        int ed = 0;
        long sum = 0;
        int len = Integer.MAX_VALUE;
        while (ss >= ed && ss < n) {
            while (sum < s && ss < n) {
                sum += arr[ss++];
            }

            while (sum >= s && ed < n){
                len = Math.min(len, ss - ed);
                sum -= arr[ed++];
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}