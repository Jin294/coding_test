#include <bits/stdc++.h>

// 숫자가 아닌것이 어디까지인지 알아야
// for문으로 문자 하나하나 훝기
using namespace std;

map<string, string> mapp {
    {"zero", "0"},
    {"one", "1"},
    {"two", "2"},
    {"three", "3"},
    {"four", "4"},
    {"five", "5"},
    {"six", "6"},
    {"seven", "7"},
    {"eight", "8"},
    {"nine", "9"}
};

int solution(string s) {
    string answer;
    
    string token = "";
    for (int i = 0; i < s.size(); i++) {
        if (s[i] >= '0' && s[i] <= '9') { // 숫자일 때
            answer += string(1, s[i]);
        } else { // 문자일 때
            token += s[i];
            // 현재 위치까지의 문자열이 맵의 키에 있는지 검사
            // 있다면
            if (mapp.find(token) != mapp.end()) {
                answer += mapp[token];
                token = "";
            }
        }   
    }
    
    int lastIdx = s.size() - 1;
    if (s[lastIdx] < '0' || s[lastIdx] > '9') {
        answer += mapp[token];
    }
    
    return atoi(answer.c_str());
}