#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    vector<int> answer;
    
    for (int ans : arr) {
        if (find(delete_list.begin(), delete_list.end(), ans) == delete_list.end()) answer.push_back(ans);
    }
    
    return answer;
}