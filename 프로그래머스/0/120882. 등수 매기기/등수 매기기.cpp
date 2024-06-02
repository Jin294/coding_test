#include <bits/stdc++.h>

using namespace std;

typedef pair<vector<int>, int> pr;

int cmp(pr one, pr two) {
    return one.second > two.second;
}


vector<int> solution(vector<vector<int>> score) {
    vector<pr> sum;
    
    for (auto s : score) {
        sum.push_back(make_pair(s, s[0] + s[1]));
    }
    
    sort(sum.begin(), sum.end(), cmp);
    
    map<int, int> board;
    
    int rank = 1;
    int sumIdx = 1;
    board[sum[0].second] = rank;
    for (int i = 1; i < sum.size(); i++) {
        if (sum[i - 1].second == sum[i].second) {
            board[sum[i].second] = rank;
            sumIdx++;
        } else {
            board[sum[i].second] = ++sumIdx;
            rank = sumIdx;
        }
    }
    
    vector<int> answer;
    
    for (auto s : score) answer.push_back(board[s[0] + s[1]]);
    
    return answer;
}