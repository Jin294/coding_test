#include <bits/stdc++.h>

using namespace std;

// 내림차순 정렬
bool order(pair<int, int> a, pair<int, int> b) {
    return a.second > b.second;
}

int solution(int k, vector<int> tangerine) {
    map<int, int> mapp;
    for (int t : tangerine) mapp[t]++;
    
    // 맵 -> 벡터 이식
    vector<pair<int, int>> vec(mapp.begin(), mapp.end()); 

    // 커스텀 정렬
    sort(vec.begin(), vec.end(), order);
    
    int sum = 0;
    int cnt = 0;
    for (auto p : vec) {
        sum += p.second;
        cnt++;
        if (sum >= k) return cnt;
    }
    
    return cnt;
}