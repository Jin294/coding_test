// 이중 다익스트라?
import java.util.*;

// 도착 지점과, 도착지점으로 가는 비용을 의미하는 클래스를 정의한다.
class Node {
	int idx;
	int cost;

	// 생성자
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

class Solution {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[][] dist;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 이차원리스트 초기화 및 값 입력
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] now : fares) {
            int parent = now[0];
            int child = now[1];
            int value = now[2];
            
            graph.get(parent).add(new Node(child, value));
            graph.get(child).add(new Node(parent, value));
        }
        
        // 거리저장배열 선언 및 초기화
        dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
            dist[i][i] = 0;
        }
        
        // 모든 노드에서 다익스트라 검사
        for (int node = 1; node <= n; node++) {
            // 방문체크 배열은 매번 초기화
            visited = new boolean[n + 1];
            
            // 노드의 개수만큼 반복
            for (int i = 0; i < n; i++) {
                int value = Integer.MAX_VALUE;
                int nodeIdx = 0;
                
                // 1번 노드부터 진행
                for (int j = 1; j <= n; j++) {
                    // 해당 노드를 방문하지 않았다면 최솟값으로 저장한다.
                    if (!visited[j] && dist[node][j] < value) {
                        value = dist[node][j];
                        nodeIdx = j;
                    }
                }
                
                // 최종 선택된 노드를 방문처리
                visited[nodeIdx] = true;
                
                ArrayList<Node> list = graph.get(nodeIdx);
                for (int j = 0; j < list.size(); j++) {
                    // 인접노드 선택
                    Node adjNode = list.get(j);
                    
                    // 인접노드가 현재 갖고 있는 최소비용과
                    // 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교해 더 작은 값 갱신
                    if (dist[node][adjNode.idx] > dist[node][nodeIdx] + adjNode.cost) {
                        dist[node][adjNode.idx] = dist[node][nodeIdx] + adjNode.cost;
                    }
                }
            }
        }
        
        // 경유지점을 i(1부터 n까지)로 설정했을 때
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 초깃값은 경유지점까지의 비용
            int sum = dist[s][i];
            
            // i에서 a까지의 최소비용 + i에서 b까지의 최소비용
            sum += (dist[i][a] + dist[i][b]);
        
            answer = Math.min(answer, sum);
        }
        
        
        return answer;
    }
}