#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int rowSize = arr.size();
    int colSize = arr[0].size();
    
    if (rowSize > colSize) { // 세로가 더 길다면 => 가로길이를 맞춰야
        for (auto& row : arr) {
            row.resize(rowSize, 0);
        }
    } else { // 가로가 더 길다면 => 세로길이를 맞춰야
        vector<int> tmp (colSize, 0);
        arr.resize(colSize, tmp);
    }
    
    return arr;
}