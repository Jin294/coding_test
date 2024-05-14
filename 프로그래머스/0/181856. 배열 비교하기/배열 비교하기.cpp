#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    // 길이 다를때 먼저 처리
    if (arr1.size() < arr2.size()) return -1;
    else if (arr1.size() > arr2.size()) return 1;
    
    // 길이 같다면 합을 구해 대소비교
    int sum1 = accumulate(arr1.begin(), arr1.end(), 0);
    int sum2 = accumulate(arr2.begin(), arr2.end(), 0);
    return sum1 > sum2 ? 1 : (sum1 == sum2 ? 0 : -1);
}