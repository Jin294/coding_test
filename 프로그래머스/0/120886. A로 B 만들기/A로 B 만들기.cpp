#include <bits/stdc++.h>

using namespace std;

int solution(string before, string after) {
    vector<int> beforeX (26, 0);
    for (char x : before) {
        beforeX[x - 'a']++;
    }
    
    vector<int> afterX (26, 0);
    for (char x : after) {
        afterX[x - 'a']++;
    }
    
    for (int i = 0; i < 26; i++) {
        if (beforeX[i] != afterX[i]) return 0;
    }
    
    return 1;
}