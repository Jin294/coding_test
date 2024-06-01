#include <bits/stdc++.h>

using namespace std;

int getGCD(int max, int min) {
    if (min == 0) return max;
    return getGCD(min, max % min);
}

int solution(int a, int b) {    
    // 1. 최대공약수로 나누어 기약분수로 만들기
    int gcd = getGCD(max(a, b), min(a, b));
    
    if (gcd != 1) {
        b /= gcd;
        a /= gcd;    
    }
    
    // 2. 분모의 소인수가 2와 5로만 이루어져 있는지 확인하기
    while (b % 2 == 0) {
        b /= 2;
    }
    
    while (b % 5 == 0) {
        b /= 5;
    }
    
    if (b == 1) return 1;
    return 2;
}