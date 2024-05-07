#include <bits/stdc++.h>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer (52);
    
    for (char x : my_string) {
        if (x >= 'A'  && x <= 'Z') {
            answer[(int)(x - 'A')]++;
        } else {
            answer[26 + (int)(x - 'a')]++;
        }
    }
    
    return answer;
}