import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringBuilder sb = new StringBuilder();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> listIterator = list.listIterator();
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (Character.isAlphabetic(arr[j]) || Character.isDigit(arr[j])) {
                    listIterator.add(arr[j]);
                } else {
                    if (arr[j] == '<') {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    } else if (arr[j] == '>') {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    } else {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            listIterator.remove();
                        }
                    }
                }
            }

            // 커서 맨 앞으로 이동
            while (listIterator.hasPrevious()) {
                listIterator.previous();
            }

            while (listIterator.hasNext()) {
                sb.append(listIterator.next());
            }
            System.out.println(sb);
        }
    }
}