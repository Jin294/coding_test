#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (vector<int> q : queries) {
        int first = q[0];
        int second = q[1];
        
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
    
    return arr;
}