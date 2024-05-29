#include <vector>
#include <numeric>
#include <limits.h>

using namespace std;

int solution(vector<int> numbers) {
    int answer = INT_MIN;
    
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = 0; j < numbers.size(); j++) {
            if (i != j) answer = max(answer, numbers[i] * numbers[j]);
        }
    }
    
    return answer;
}