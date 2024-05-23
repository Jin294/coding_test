#include <vector>

using namespace std;

int solution(vector<int> numbers, int k) {
    int idx = 0;
    
    while (k-- > 1) {
        idx = (idx + 2) % numbers.size();
    }
    
    return numbers[idx];
}