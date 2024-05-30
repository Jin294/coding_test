#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> board) {
    vector<int> dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    vector<int> dx = {0, 0, -1, 1, -1, 1, 1, -1};
    
    int len = board.size();

    for (size_t row = 0; row < len; row++) {
        for (size_t col = 0; col < len; col++) {
            if (board[row][col] == 1) {
                for (int i = 0; i < 8; i++) {
                    int nr = row + dy[i];
                    int nc = col + dx[i];
                    
                    if (nr < 0 || nr >= len || nc < 0 || nc >= len) {
                        continue;
                    }
                    
                    if (board[nr][nc] == 0) {
                        board[nr][nc] = 2;
                    }
                }
            }
        }
    }
    
    int answer = 0;
    for (size_t row = 0; row < len; row++) {
        for (size_t col = 0; col < len; col++) {
            if (board[row][col] == 0) {
                answer++;
            }
        }
    }
    
    return answer;
}