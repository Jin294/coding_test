#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    
    for (int i = 0; i < query.size(); i++) {
        if (i & 1) { // 인덱스 홀수 => 앞부분버린다
            arr.erase(arr.begin(), arr.begin() + query[i]);
        } else { // 인덱스 짝수 => 뒷부분버린다
            arr.erase(arr.begin() + query[i] + 1, arr.end());
        }
    }
    
    return arr;
}