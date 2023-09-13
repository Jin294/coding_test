import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        String number;
        int idx;

        public Node(String number, int idx) {
            this.number = number;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Node> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            map.put(str, new Node(str, idx++));
        }

        ArrayList<Node> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int size = Math.min(k, list.size());
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i).number).append("\n");
        }
        System.out.println(sb);
    }
}