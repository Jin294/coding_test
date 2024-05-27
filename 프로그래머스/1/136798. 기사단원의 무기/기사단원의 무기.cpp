#include <bits/stdc++.h>

using namespace std;

int getDivisorSize(int num) {
    int cnt = 0;
    for (int i = 1; i * i <= num; i++) {
        if (num % i > 0) continue;
        
        if (i * i == num) cnt++;
        else cnt += 2;
    }
    
    return cnt;
}

int solution(int number, int limit, int power) {
    vector<int> vec;
    // 공격력 구하기
    for (int i = 1; i <= number; i++) vec.push_back(getDivisorSize(i));
    
    // 제한수치 넘어가면 협약 지켜야
    for (int& num : vec) if (num > limit) num = power;

    return accumulate(vec.begin(), vec.end(), 0);
}