#include <algorithm>

using namespace std;

int calculateGCD(int first, int second) {
    if (first % second == 0) return second;
    return calculateGCD(second, first % second);
}

int solution(int n) {
    int first = max(6, n);
    int second = min(6, n);
    int gcd = calculateGCD(first, second);
    
    return first / gcd * second / 6;
}