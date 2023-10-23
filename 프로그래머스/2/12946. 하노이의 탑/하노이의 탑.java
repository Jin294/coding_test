import java.util.*;

class Solution{
    static ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        recursion(n, 1, 3, 2);
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public void recursion(int n, int start, int end, int mid) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        // 중간지점까지 n-1개를 옮김
        recursion(n - 1, start, mid, end);
        
        // 맨 밑바닥 원판을 옮긴다
        list.add(new int[]{start, end});
        
        // 중간지점에 옮긴 n-1개의 원판을 목적지로 옮긴다
        recursion(n - 1, mid, end, start);
    }
}