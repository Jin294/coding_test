
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int sum = 0;
    
    for (int num : numbers) {
        sum += num;
        
        if (sum > n) break;
    }
    
    return sum;
}