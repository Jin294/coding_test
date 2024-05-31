#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> sides) {
    int b = max(sides[0], sides[1]);    
    int a = min(sides[0], sides[1]);    
    
    set<int> s;
    
    // 제일 긴것이 b라고 할 때
    // a + c > b
    // b가 제일 기니까 b보다 작거나 같아야
    for (int c = b; c > 0; c--) {
        if (a + c > b) s.insert(c);
    }
    
    // c가 제일 길 때
    // a + b > c && c가 제일 기니까 b보다 커야한다.
    for (int c = b; c < a + b; c++) {
        s.insert(c);
    }
    
    return s.size();
}