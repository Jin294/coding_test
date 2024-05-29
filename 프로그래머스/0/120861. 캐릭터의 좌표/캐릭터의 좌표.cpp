#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer = {0, 0};
    
    int maxWidth = board[0] / 2;
    int maxHeight = board[1] / 2;
    
    for (string key : keyinput) {
        if (key == "left" && (abs(answer[0] - 1) <= maxWidth)) {
            answer[0]--;
        } else if (key == "right" && (abs(answer[0] + 1) <= maxWidth)) {
            answer[0]++;
        } else if (key == "up" && (abs(answer[1] + 1) <= maxHeight)) {
            answer[1]++;
        } else if (key == "down" && (abs(answer[1] - 1) <= maxHeight)) {
            answer[1]--;
        }
        
    }
    
    return answer;
}