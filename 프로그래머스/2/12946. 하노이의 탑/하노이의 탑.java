import java.util.*;

class Solution {
    static ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        move(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void move(int n,int start, int end, int mid) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        move(n - 1, start, mid, end);
        list.add(new int[]{start, end});
        move(n - 1, mid, end, start);
    }
}