#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    
    bool visited[100'001];
    fill(visited, visited + 100'001, false);
    
    for (int num : arr) {
        if (!visited[num] && answer.size() < k) {
            visited[num] = true;
            answer.push_back(num);
        }
    }
    
    int len = answer.size();
    if (len < k) {
        for (int i = 0; i < k - len; i++) answer.push_back(-1);
    }
    
    return answer;
}