#include <bits/stdc++.h>

using namespace std;

bool checkIsBabbling(string word) {
    for (char w : word) {
        if (!isdigit(w)) {
            return false;
        }
    }
    
    return true;
}

int solution(vector<string> babbling) {
    vector<string> words = {"aya", "ye", "woo", "ma"};
    
    for (string& b : babbling) {
        for (string w : words) {
            auto idx = b.find(w);
            
            if (idx != string::npos) {
                for (auto i = idx; i < idx + w.size(); i++){
                    b[i] = '1';
                }
            }
        }
    }
        
    int answer = 0;
    
    for (string b: babbling) {
        if(checkIsBabbling(b)) {
            answer++;
        }
    }

    return answer;
}