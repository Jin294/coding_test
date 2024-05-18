#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int> > answer;
    vector<int> tmp (n, 0);
    answer.resize(n, tmp);

    answer[0][0] = 1;
    int num = 2;

    int row = 0;
    int col = 0;

    while (num <= n * n) {
        while (col + 1 < n && answer[row][col + 1] == 0) {
            col++;
            answer[row][col] = num++;
        }
        

        while (row + 1 < n && answer[row + 1][col] == 0) {
            row++;
            answer[row][col] = num++;
        }

        while (col - 1 >= 0 && answer[row][col - 1] == 0) {
            col--;
            answer[row][col] = num++;
        }
        

        while (row - 1 >= 0 && answer[row - 1][col] == 0) {
            row--;
            answer[row][col] = num++;
        }
        
    }
    
    return answer;
}