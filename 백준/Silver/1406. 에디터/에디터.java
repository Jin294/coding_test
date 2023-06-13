import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        // listIterator : 자체적으로 커서가 있다.
        // 초기 생성 시 커서가 0으로 만들어짐
        // 커서 : 요소 사이에 있음
        // next() : 커서 위치를 오른쪽으로 옮기고 커서의 왼쪽 요소를 반환함
        // previous() : 커서 위치를 왼쪽으로 옮기고 커서의 오른쪽 요소를 반환함
        // remove() : 커서의 오른쪽 요소를 제거함
        ListIterator<Character> iter = list.listIterator();

        // 조건 : 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
        while (iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < n; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(command.charAt(2));
                    break;
            }
        }

        // LinkedList는 for문보다 for-each를 사용하는게 더 빠르다!
        StringBuilder sb = new StringBuilder();
        for (Character x : list) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}