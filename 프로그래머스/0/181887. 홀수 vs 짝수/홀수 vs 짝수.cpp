#include <vector>

using namespace std;

// 문제 말장난
// 홀수번째 원소 => 인덱스 짝수
// 짝수번째 원소 => 인덱스 홀수

int solution(vector<int> num_list) {
    int oddSum = 0;
    int evenSum = 0;
    
    for (int i = 0; i < num_list.size(); i++) {
        if (i & 1) evenSum  += num_list[i];
        else oddSum += num_list[i];
    }
    
    return evenSum > oddSum ? evenSum : oddSum;
}