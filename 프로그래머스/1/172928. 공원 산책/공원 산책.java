import java.util.*;

class Solution {
    // N, S, W, E
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int h, w;
    
    Map<Character, Integer> directions = new HashMap<>();
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        
        directions.put('N', 0);
        directions.put('S', 1);
        directions.put('W', 2);
        directions.put('E', 3);
        
        int[] answer = getStartPoint(park);
        
        for (String route : routes) {
            answer = move(park, route, answer[0], answer[1]);
        }
       
        return answer;
    }
    
    public boolean isObstacle(String[] park, int row, int col) {
        return park[row].charAt(col) == 'X';
    }
    
    public int[] move(String[] park, String route, int row, int col) {
        int[] now = {row, col};
        
        int direction = directions.get(route.charAt(0));
        int distance = (int) (route.charAt(2) - '0');
        
        int nr = row;
        int nc = col;
        
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
    
    public boolean isWithinRange(int row, int col) {
        return row >= 0 && col >= 0 && row < h && col < w;
    }
    
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