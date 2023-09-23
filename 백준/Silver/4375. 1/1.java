import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int build = 1;
            int len = 1;

            while (build % n != 0) {
                build = (build * 10 + 1) % n;
                len++;
            }

            System.out.println(len);
        }
    }
}