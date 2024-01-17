import java.util.*;

class Solution {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        recursion(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void recursion(int n, int start, int end, int mid) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        recursion(n - 1, start, mid, end);
        recursion(1, start, end, mid);
        recursion(n - 1, mid, end, start);
    }
}