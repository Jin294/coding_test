#include <bits/stdc++.h>

using namespace std;

int solution(int M, int N) {
    int big = max(M, N);
    int small = min(M, N);
    return (big - 1) + big * (small - 1);
}