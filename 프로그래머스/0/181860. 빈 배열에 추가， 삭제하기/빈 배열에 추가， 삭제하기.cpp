#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<bool> flag) {
    vector<int> answer;
    
    for (int i = 0; i < arr.size(); i++) {
        if (flag[i]) { // true => arr[i]를 arr[i] * 2번 넣기
            for (int j = 0; j < arr[i] * 2; j++) {
                answer.push_back(arr[i]);
            }
        } else { // false => arr[i]개의 원소 제거
            for (int j = 0; j < arr[i]; j++) {
                answer.pop_back();
            }
        }
    }
    
    return answer;
}