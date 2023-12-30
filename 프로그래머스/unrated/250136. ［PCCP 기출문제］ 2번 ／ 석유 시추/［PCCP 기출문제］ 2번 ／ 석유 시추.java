import java.util.*;

// 유니온 파인드 문제
// 유니온 메서드
// 파인드 메서드

class Solution {
    
    static int[] moveY = {-1, 0, 1, 0}; // 북, 동, 서, 남
    static int[] moveX = {0, 1, 0, -1};
    
    static int[][] gLand;
    static int[] parent;
    static int max, y, x;
    
    static final int OIL = 1;
    
    public int solution(int[][] land) {
        gLand = land;
        init();
        goUnion();
        return getMaxOil(countOilMass());
    }
    
    public Map<Integer, Integer> countOilMass() {
        Map<Integer, Integer> countOil = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            if (gLand[i / x][i % x] == OIL) {
                int root = find(i);
                
                countOil.put(root, countOil.getOrDefault(root, 0) + 1);
            }
        }
        
        return countOil;
    }
    
    public int getMaxOil(Map<Integer, Integer> countOil) {
        // 시추관 위치에 따른 뽑을 수 있는 석유의 최댓값 찾기
        int answer = 0;
        for (int j = 0; j < x; j++) {
            int sum = 0;
            Set<Integer> uniqueParents = new HashSet<>();
            for (int i = 0; i < y; i++) {
                if (gLand[i][j] == OIL) {
                    int root = find(i * x + j);
                    if (!uniqueParents.contains(root)) {
                        uniqueParents.add(root);
                        sum += countOil.get(root);
                    }
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        
        return x;
    }
    
    public void union(int orig, int next) {
        orig = find(orig);
        next = find(next);
        
        if (orig != next) {
            if (orig > next) {
                parent[orig] = next;
            } else {
                parent[next] = orig;
            }
        }
    }
    
    public void goUnion() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (gLand[i][j] == OIL) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + moveY[k];
                        int nc = j + moveX[k];
                        
                        if (isIn(nr, nc) && gLand[nr][nc] == OIL) {
                            union(i * x + j, nr * x + nc);
                        }
                    }
                }
            }
        }
    }
    
    public void init() {
        y = gLand.length;
        x = gLand[0].length;
        
        parent = new int[y * x];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    
    public boolean isIn(int row, int col) {
        return row >= 0 && col >= 0 && row < y && col < x;
    }
}