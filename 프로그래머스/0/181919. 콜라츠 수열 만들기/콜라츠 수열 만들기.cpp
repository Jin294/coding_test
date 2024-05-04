#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer = {n};
    
    while (n != 1) {
        n = ((n & 1) == 0) ? (n / 2) : (n * 3 + 1);
        answer.push_back(n);
    }
    
    return answer;
}