// 1. 일단 전체 배열 검사 : 모두 일치하면 바로 압축, 끝냄
// 2. 아니라면 분할해서 검사한다.

import java.util.*;

class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        recursion(0, 0, arr.length, arr);
        return answer;
    }
    
    public void recursion(int row, int col, int size, int[][] arr) {
        if (isAllSame(row, col, size, arr)) {
            answer[arr[row][col]]++;
            return;
        }
        
        int newSize = size / 2;
        recursion(row, col, newSize, arr);
        recursion(row, col + newSize, newSize, arr);
        recursion(row + newSize, col, newSize, arr);
        recursion(row + newSize , col + newSize, newSize, arr);
    }
    
    public boolean isAllSame(int row, int col, int size, int[][] arr) {
        int num = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}