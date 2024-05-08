#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    
    for (vector<int> interval : intervals) {
        int start = interval[0];
        int end = interval[1];
        
        for (int i = start; i <= end; i++) {
            answer.push_back(arr[i]);
        }
    }
    
    return answer;
}