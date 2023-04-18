import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int val;
        int count;
        int idx;

        public Node(int val, int count, int idx) {
            this.val = val;
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.idx - o.idx;
            }
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!list.contains(num)) {
                list.add(num);
                map.put(num, new Node(num, 1, i));
            } else {
                map.get(num).count++;
            }
        }

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            nodes.add(map.get(list.get(i)));
        }

        Collections.sort(nodes);

        for (int i = 0; i < nodes.size(); i++) {
            Node target = nodes.get(i);
            if (target.count == 0) {
                break;
            }

            while (target.count != 0) {
                System.out.print(target.val + " ");
                target.count--;
            }
        }
    }
}