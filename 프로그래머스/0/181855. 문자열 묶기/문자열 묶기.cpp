#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> strArr) {
    map<int, int> cnt;
    for (string& str : strArr) cnt[str.size()]++;
    
    int maxCnt = 0;
    for (auto pair : cnt) if (pair.second > maxCnt) maxCnt = pair.second;

    return maxCnt;
}