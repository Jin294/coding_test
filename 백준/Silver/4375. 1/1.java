import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) !=  null) {
            int n = Integer.parseInt(s);

            long num = 1;
            int len = 1;
            while (num % n != 0) {
                num = (num * 10 + 1) % n;
                len++;
            }

            System.out.println(len);
        }
    }
}