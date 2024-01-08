import java.util.*;

class Node implements Comparable<Node> {
    int idx, y, x;
    
    Node left, right;
    
    public Node(int idx, int y, int x) {
        this.idx = idx;
        this.y = y;
        this.x = x;
    }
    
    // y 기준 내림차순정렬 -> y 같으면 x 기준 오름차순정렬
    @Override
    public int compareTo(Node o) {
        if (this.y == o.y) {
            return this.x - o.x;
        }
        return o.y - this.y;
    }
}

class Solution {
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][1], nodeinfo[i][0]));
        }
        
        Collections.sort(list);
        Node root = list.get(0);
        int[][] answer = new int[2][nodeinfo.length];
        
        for (int i = 1; i < list.size(); i++) {
            makeTree(root, list.get(i));
        }
        
        idx = 0;
        preOrder(root, answer[0]);
        idx = 0;
        postOrder(root, answer[1]);
        
        return answer;
    }
    
    public void preOrder(Node now, int[] answer) {
        if (now == null) {
            return;
        }
        
        answer[idx++] = now.idx;
        preOrder(now.left, answer);
        preOrder(now.right, answer);
    }
    
    public void postOrder(Node now, int[] answer) {
        if (now == null) {
            return;
        }
        
        postOrder(now.left, answer);
        postOrder(now.right, answer);
        answer[idx++] = now.idx;
    }
    
    public void makeTree(Node parent, Node child) {
        // 부모의 x좌표가 자식의 x좌표보다 작다면
        if (parent.x < child.x) {
            // 오른쪽 자식이 빈자리일 때
            if (parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        // 부모의 x좌표가 자식의 x좌표보다 크다면
        } else if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        }
    }
}