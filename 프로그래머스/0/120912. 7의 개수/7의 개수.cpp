#include <vector>

using namespace std;

int solution(vector<int> array) {
    int answer = 0;
    
    for (int num : array) {
        while (num > 0) {
            if (num % 10 == 7) answer++;
            num /= 10;
        }
    }
    
    return answer;
}