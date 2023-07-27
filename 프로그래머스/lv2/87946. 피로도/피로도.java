class Solution {
    static int[] order;
    static boolean[] visited;
    static int n, now, answer;
    public int solution(int k, int[][] dungeons) {
        now = k;
        n = dungeons.length;
        order = new int[n];
        visited = new boolean[n];
        recursion(dungeons, 0);
        return answer;
    }
    
    public void recursion(int[][] dungeons, int depth) {
        if (depth == n) {
            int remain = now;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (remain >= dungeons[order[i]][0]) {
                    remain -= dungeons[order[i]][1];
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }
        
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                recursion(dungeons, depth + 1);
                visited[i] = false;                
            }
        }
    }
}