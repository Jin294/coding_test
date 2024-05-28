#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    string answer = "";
    map<char, int> mapp;
    for (char ch : s) mapp[ch]++;
    for (auto key : mapp) if (mapp[key.first] == 1) answer += key.first;
    
    return answer;
}