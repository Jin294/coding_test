import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    Map<Character, Node> child = new HashMap<>();

    boolean isEndOfWord;
}

class Trie {
    Node root = new Node();

    void insert(String str) {
        Node cur = root;

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            cur.child.putIfAbsent(x, new Node());

            cur = cur.child.get(x);
        }

        cur.isEndOfWord = true;
    }

    boolean contains(String str) {
        Node cur = root;

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            cur = cur.child.get(x);

            if (cur == null) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (trie.contains(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}