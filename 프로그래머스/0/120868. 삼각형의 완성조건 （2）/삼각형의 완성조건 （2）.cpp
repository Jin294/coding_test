#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> sides) {
    int b = max(sides[0], sides[1]);    
    int a = min(sides[0], sides[1]);    
    
    set<int> s;
    
    // 제일 긴것이 b라고 할 때
    // a + c > b
    // -> c > b - a
    for (int c = b; c > 0; c--) {
        if (a + c > b) s.insert(c);
    }
    
    // c가 제일 길 때
    // a + b > c
    for (int c = b; c < a + b; c++) {
        s.insert(c);
    }
    
    return s.size();
}