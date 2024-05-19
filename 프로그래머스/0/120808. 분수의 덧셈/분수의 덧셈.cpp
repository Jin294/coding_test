#include <bits/stdc++.h>

using namespace std;

int getGCD(int first, int second) {
    if (first % second == 0) return second;
    return getGCD(second, first % second);
}

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    // 분모, 분자 계산
    int numer = numer1 * denom2 + numer2 * denom1;
    int denom = denom1 * denom2;
    
    if (numer == denom) return {1, 1};
    
    // 분모, 분자의 최대공약수 구하기
    int gcd = getGCD(max(numer, denom), min(numer, denom));
    
    return {numer / gcd, denom / gcd};
}