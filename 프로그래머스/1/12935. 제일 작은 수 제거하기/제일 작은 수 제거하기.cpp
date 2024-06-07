#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    if (arr.size() == 1) return {-1};
    
    // min_element는 최솟값의 반복자(이터레이터)를 반환한다.
    auto minPos = min_element(arr.begin(), arr.end());

    arr.erase(minPos);
    
    return arr;
}