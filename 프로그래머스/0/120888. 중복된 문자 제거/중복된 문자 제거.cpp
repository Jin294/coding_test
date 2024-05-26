#include <bits/stdc++.h>

using namespace std;

string solution(string my_string) {
    map<char, int> mapp;
    for (int i = 0; i < 26; i++) {
        mapp['a' + i] = 0;
    }
    mapp[' '] = 0;
    
    string answer = "";
    for (const char& ch : my_string) {
        if (mapp[ch] == 0) {
            answer += ch;
            mapp[ch]++;
        }
    }
    
    return answer;
}