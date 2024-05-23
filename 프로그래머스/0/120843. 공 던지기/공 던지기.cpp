#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int k) {
    int idx = 0;
    int cnt = 0;
    
    while (cnt != k - 1) {
        idx += 2;
        idx %= numbers.size();
        cnt++;
    }
    
    return numbers[idx];
}