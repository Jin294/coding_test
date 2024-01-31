import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 편의상, 정점개수 V 와 간선 개수 E를 저장
        int V = n;
        int E = roads.length;
        
        // 최단시간(거리)를 저장할 배열
        int[] dist = new int[V + 1];
        // 최단시간(거리)를 경신하기 위해 최댓값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 출발지점은 이동 필요 없으므로 0으로 설정
        dist[destination] = 0;
        
        // 그래프 만들기
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        // 방문여부 체크할 부울배열
        boolean[] visited = new boolean[V + 1];
        
        // 너비우선탐색과정을 메서드로 분리
        BFS(visited, dist, destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] != Integer.MAX_VALUE ? dist[sources[i]] : -1;
        }
        return answer;
    }
    
    public void BFS(boolean[] visited, int[] dist, int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visited[now] = true;
        while(!q.isEmpty()) {
            int start = q.poll();
            
            ArrayList<Integer> list = graph.get(start);
            for (int i = 0; i < list.size(); i++) {
                int arrival = list.get(i);
                if (!visited[arrival]) {
                    visited[arrival] = true;
                    dist[arrival] = Math.min(dist[start] + 1, dist[arrival]);
                    q.add(arrival);
                }
            }
        }
    }
}