#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    int answer = 0;
    
    for (string str : dic) {
        // 1. dic의 단어의 알파벳 수 세기
        map<char, int> count;
        
        for  (char x : str) count[x]++;
        
        // 2. spell의 글자들이 한개만 들어있는지 비교
        int tmp = 0;
        for (string s : spell) {
            if (count[s[0]] == 1) tmp++;
        }
        
        if (tmp == spell.size()) answer++;
    }
    
    return answer > 0 ? 1 : 2;
}