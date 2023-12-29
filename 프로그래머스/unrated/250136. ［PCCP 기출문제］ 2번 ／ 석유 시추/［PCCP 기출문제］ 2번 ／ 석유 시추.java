import java.util.*;

// 유니온 파인드 문제

class Solution {
    // 북 동 남 서
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};
    
    static int[] parents;
    
    static int row, col;
    static final int OIL = 1;
    public int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        
        // 유니온파인드 밑준비
        // 이차원배열을 분리해 길다란 일차원 배열로 만든다
        // 부모정보의 초깃값은 인덱스값으로 (자기 자신)
        parents = new int[row * col];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        // 중복체크 방지위한 부울배열
        // 이차원배열 탐색하며 석유칸끼리 묶는다
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == OIL) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + moveY[k];
                        int nc = j + moveX[k];
                        
                        if ((nr >= 0 && nc >= 0 && nr < row && nc < col) && land[nr][nc] == OIL) {
                            union(i * col+ j, nr * col + nc);
                        }
                    }
                }
            }
        }
        
        // 석유칸 카운트
        Map<Integer, Integer> countMap = new HashMap<>();
        countOil(countMap, land);
        
        // 본격 시추
        int answer = 0;
        for (int j = 0; j < col; j++) {
            // roots 중복을 거를 set
            Set<Integer> uniqueRoots = new HashSet<>();
            int sum = 0;
            // 각각의 열마다 검사
            for (int i = 0; i < row; i++) {
                // 석유가 있는 칸이라면 
                if (land[i][j] == OIL) {
                    // 그 근원(부모)를 찾는다
                    int root = find(i * col + j);
                    // 부모가 등록되어있지 않다면
                    if (!uniqueRoots.contains(root)) {
                        uniqueRoots.add(root);
                        sum += countMap.get(root);
                    }
                    
                    // 부모가 등록되어 있다 -> 이미 그 덩어리는 추가함.
                }
            }
            
            // 최댓값 경신
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public void countOil(Map<Integer, Integer> map, int[][] land) {
        for (int i = 0; i < row * col; i++) {
            if (land[i / col][i % col] == OIL) {
                int root = find(i);

                map.put(root, map.getOrDefault(root, 0) + 1);
            }
        }
    }
    
    public int find(int num) {
        while (num != parents[num]) {
            parents[num] = parents[parents[num]];
            num = parents[num];
        }
        
        return num;
    }
    
    public void union(int orig, int next) {
        orig = find(orig);
        next = find(next);
        
        if (orig != next)  {
            if (orig < next) {
                parents[next] = orig;
            } else {
                parents[orig] = next;
            }
        }
    }
}