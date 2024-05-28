#include <cmath>

using namespace std;

int solution(int n) {
    int sqrtN = (int) sqrt(n);
    return sqrtN * sqrtN == n ? 1 : 2;
}