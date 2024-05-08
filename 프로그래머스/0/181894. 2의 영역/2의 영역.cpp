#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    
    // 앞부분
    int start = -1;
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == 2) {
            start = i;
            break;
        }
    }
    
    if (start == -1) {
        answer.push_back(-1);
        return answer;
    }
    
    // 뒷부분
    int end = arr.size() - 1;
    for (int i = end; i >= 0; i--) {
        if (arr[i] == 2) {
            end = i;
            break;
        }
    }
    
    // 범위 내의 요소 추려내기
    for (int i = start; i <= end; i++) {
        answer.push_back(arr[i]);
    }
    
    return answer;
}