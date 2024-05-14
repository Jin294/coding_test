#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> strArr) {
    vector<int> cnt(100'001);
    fill(cnt.begin(), cnt.begin() + 100001, 0);
    for (string str : strArr) cnt[str.size()]++;
    return *max_element(cnt.begin(), cnt.end());
}