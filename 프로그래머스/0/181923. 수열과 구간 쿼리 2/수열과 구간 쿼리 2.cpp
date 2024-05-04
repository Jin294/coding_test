#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    int minn;
    vector<int> answer;
    for (vector<int> q : queries) {
        int first = q[0];
        int second = q[1];
        int num = q[2];
        
        minn = 1'000'000;
        for (int i = first; i <= second; i++) {
            minn = arr[i] > num ? min(minn, arr[i]) : minn;
        }
        answer.push_back(minn == 1'000'000 ? -1 : minn);
    }
    return answer;
}