import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 이차원 리스트 만들기
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        
        // 이차원 리스트로 그래프 구현
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                
                if (computers[i][j] == 1) {
                    graph.get(i + 1).add(j + 1);
                }
            }
        }
        
        // 개수 세기
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void DFS(int now) {
        visited[now] = true;
        ArrayList<Integer> list = graph.get(now);
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                DFS(list.get(i));
            }
        }
    }
}