#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    
    for (int i = 0; i < arr.size(); i++) {
        for (int j = arr[i]; j > 0; j--) {
            answer.push_back(arr[i]);
        }
    }
    
    return answer;
}