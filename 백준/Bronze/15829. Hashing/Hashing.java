import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger sum = new BigInteger("0");
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - 'a' + 1;
            sum = sum.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(31).pow(i)));
        }
        System.out.println(sum.remainder(BigInteger.valueOf(1_234_567_891)));
    }
}