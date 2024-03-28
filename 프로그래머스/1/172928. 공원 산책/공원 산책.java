import java.util.*;

class Solution {
    // N, S, W, E
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int h, w;
    
    Map<Character, Integer> directions = new HashMap<>();
    public int[] solution(String[] park, String[] routes) {
    	// 가로 세로를 변수에 저장
        h = park.length;
        w = park[0].length();
        
        // 방향별 인덱스 연결
        directions.put('N', 0);
        directions.put('S', 1);
        directions.put('W', 2);
        directions.put('E', 3);
        
        int[] answer = getStartPoint(park);
        
        for (String route : routes) {
            answer = move(park, route, answer);
        }
       
        return answer;
    }
    
    // 이동
    public int[] move(String[] park, String route, int[] now) {
        int direction = directions.get(route.charAt(0));
        int distance = (int) (route.charAt(2) - '0');
        
        int nr = now[0];
        int nc = now[1];
        
        // 한 칸씩 이동해야 경로상에 장애물이 있는지를 알 수 있다!
        for (int i = 0; i < distance; i++) {
            nr += dy[direction];
            nc += dx[direction];
            
            if (!isWithinRange(nr, nc)) {
                return now;
            }
            
            if (isObstacle(park, nr, nc)) {
                return now;
            }
        }
        
        return new int[]{nr, nc};
    }
    
    // 범위를 벗어났는지 검사
    public boolean isWithinRange(int row, int col) {
        return row >= 0 && col >= 0 && row < h && col < w;
    }
    
    // 현재 칸이 장애물인지 검사
    public boolean isObstacle(String[] park, int row, int col) {
        return park[row].charAt(col) == 'X';
    }
        
    // 시작위치 S 찾기
    public int[] getStartPoint(String[] park) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S'){
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
}