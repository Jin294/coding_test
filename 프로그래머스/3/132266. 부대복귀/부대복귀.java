import java.util.*;

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 편의상, 정점개수 V 와 간선 개수 E를 저장
        int V = n;
        int E = roads.length;
        
        // 최단시간(거리)를 저장할 배열
        int[] dist = new int[V + 1];
        // 최단시간(거리)를 경신하기 위해 최댓값으로 초기화
        Arrays.fill(dist, MAX);
        
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
        
        dijkstra(dist, destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] != MAX ? dist[sources[i]] : -1;
        }
        return answer;
    }
    
    public void dijkstra(int[] dist, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()) {
            int start = q.poll();
            
            ArrayList<Integer> list = graph.get(start);
            for (int i = 0; i < list.size(); i++) {
                int arrival = list.get(i);
                if (dist[arrival] > dist[start] + 1) {
                    dist[arrival] = dist[start] + 1;
                    q.add(arrival);
                }
            }
        }
    }
}