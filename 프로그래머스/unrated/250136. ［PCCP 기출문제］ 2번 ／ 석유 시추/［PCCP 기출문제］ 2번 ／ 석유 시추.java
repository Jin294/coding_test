import java.util.*;

class Solution {
    static int[] moveY =  {-1, 0, 1, 0};
    static int[] moveX =  {0, 1, 0, -1};
    static int[] parent;
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        
        parent = new int[row * col];
        
        for (int i = 0; i < row * col; i++) {
            parent[i] = i;
        }    

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + moveY[k];
                        int nc = j + moveX[k];
                        
                        if (nr >= 0 && nc >= 0 && nr < row && nc < col && land[nr][nc] == 1) {
                            union(i * col + j, nr * col + nc);
                        }
                    }
                }
            }
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < row * col; i++) {
            if (land[i / col][i % col] == 1) {
                int root = find(i);
                countMap.put(root, countMap.getOrDefault(root, 0) + 1);
            }
        }
        
        int answer = 0;
        for (int j = 0; j < col; j++) {
            Set<Integer> uniqueRoots = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < row; i++) {
                if (land[i][j] == 1) {
                    int root = find(i * col + j);
                    if (!uniqueRoots.contains(root)) {
                        uniqueRoots.add(root);
                        sum += countMap.get(root);
                    }
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
    public void union(int old, int neu) {
        old = find(old);
        neu = find(neu);
        
        if (old != neu) {
            if (old < neu) {
                parent[neu] = old;
            } else {
                parent[old] = neu;
            }
        }
    }
}
