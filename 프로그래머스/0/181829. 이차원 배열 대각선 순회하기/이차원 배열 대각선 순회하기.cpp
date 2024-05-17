#include <vector>

using namespace std;

int solution(vector<vector<int>> board, int k) {
    int row = board.size();
    int col = board[0].size();
    
    int answer = 0;
    
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (i + j <= k) answer += board[i][j];
        }
    }
    
    return answer;
}