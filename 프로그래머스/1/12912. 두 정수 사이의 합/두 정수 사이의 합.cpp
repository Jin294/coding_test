#include <cmath>

using namespace std;

long long solution(int a, int b) {
    int small = min(a, b);
    int big = max(a, b);

    long long answer = small;
        
    while (small++ < big) {
        answer += small;
    }
    
    return answer;
}