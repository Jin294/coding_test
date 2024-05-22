#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> emergency) {
    vector<int> copy (emergency.begin(), emergency.end());
    sort(copy.begin(), copy.end(), greater<int>());
    unordered_map<int, int> mapp;
    for (int i = 0; i < copy.size(); i++) {
        mapp.insert({copy[i], i + 1});
    }
    
    vector<int> answer;
    for (int i = 0; i < emergency.size(); i++) answer.push_back(mapp[emergency[i]]);
    return answer;
}