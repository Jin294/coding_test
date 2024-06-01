#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> lines) {
    int answer = 0;
    
    // 선분의 길이만큼 생성
    vector<int> check(201, 0);
    
    for (auto line : lines) {
        // 음수인 인덱스 조정
        int first = line[0] + 100;
        int second = line[1] + 100;
        
        while (first < second) {
            check[first++]++;
        }
    }
    
    for (int i = 0; i < check.size(); i++) if (check[i] >= 2) answer++; 
    
    return answer;
}