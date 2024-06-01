#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pr;

int cmp(pr a, pr b) {
    if (a.first == b.first) return a.second > b.second;
    return a.first < b.first;
}

vector<int> solution(vector<int> numlist, int n) {
    vector<int> answer;
    
    vector<pr> vec;
    for (int num : numlist) vec.push_back(make_pair(abs(n - num), num));
    
    sort(vec.begin(), vec.end(), cmp);
    
    for (auto item : vec) answer.push_back(item.second);
    
    return answer;
}