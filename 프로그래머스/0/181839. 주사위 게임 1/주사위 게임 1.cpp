#include <bits/stdc++.h>

using namespace std;

int solution(int a, int b) {
    int first = a & 1;
    int second = b & 1;
    
    if (first == second && first == 1) return (int)pow(a, 2) + (int)pow(b, 2);
    else if (first == second && first == 0) return abs(a - b);
    else return 2 * (a + b);
}