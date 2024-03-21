import java.util.*;

class Point {
    long x;
    long y;
    
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        int len = line.length;
        List<Point> list = new ArrayList<>();
        
        // 선분들 중, 두 개를 골라 그 교차점을 찾아야 한다.
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                Point intersection = getIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                
                if (intersection != null) {
                    list.add(intersection);
                }
            }
        }
        
        // 범위를 찾는다
        Point max = getMaximun(list);
        Point min = getMinimun(list);
        
        // 1 더하는 이유는 가로세로 0일때 포함해야 해서
        int height = (int) (max.y - min.y + 1);
        int width = (int) (max.x - min.x + 1);
        
        // 미리 빈칸에 점찍기
        char[][] board = new char[height][width];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        // 좌표 -> 배열 전환
        for (Point p : list) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y -  p.y);
            
            board[y][x] =  '*';
        }
        
        // 문자 배열을 문자열 배열로
        String[] answer = new String[board.length];
        for (int i = 0; i < answer.length; i++)  {
            answer[i] = new String(board[i]);
        }
        
        return answer;
    }
    
    // 두 선분으로 교점 찾는 메서드
    // 정수 좌표만 저장해야 함
    public Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 분모 : denominator
        double denominator = a1 * b2 - a2 * b1;
        double x = (double) (b1 * c2 - b2 * c1) / denominator;
        double y = (double) (a2 * c1 - a1 * c2) / denominator;
        
        // 정수인지 체크
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }
        
        return new Point((long) x, (long) y);
    }
    
    // 가장 작은 x, y 좌표를 찾기
    public Point getMinimun(List<Point> list) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for (Point p : list) {
            if (p.x < x) {
                x = p.x;
            }
            
            if (p.y < y) {
                y = p.y;
            }
        }
        
        return new Point(x, y);
    }
    
    // 가장 큰 x, y 좌표를 찾기
    public Point getMaximun(List<Point> list) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for (Point p : list) {
            if (p.x > x) {
                x = p.x;
            }
            
            if (p.y > y) {
                y = p.y;
            }
        }
        
        return new Point(x, y);
    }
}