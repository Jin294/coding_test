#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int rowSize = arr.size();
    int colSize = arr[0].size();
    
    if (rowSize > colSize) { // 세로가 더 길다면 => 가로길이를 맞춰야
        for (auto& vc : arr) {
            for (int i = 0; i < rowSize - colSize; i++) vc.push_back(0);
        }
    } else { // 가로가 더 길다면 => 세로길이를 맞춰야
        vector<int> tmp;
        for (int i = 0; i < colSize; i++) tmp.push_back(0);
        for (int i = 0; i < colSize - rowSize; i++) arr.push_back(tmp);
    }
    
    return arr;
}