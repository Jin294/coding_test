#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    vector<int> arr(n, 0);
    answer.resize(n, arr);
    
    for (int i = 0; i < n; i++) answer[i][i] = 1;
    return answer;
}