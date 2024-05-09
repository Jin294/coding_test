#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    // n번째 원소 이후
    vector<int> v1 (num_list.begin() + n, num_list.end());
    
    // n번째 까지의 원소
    vector<int> v2 (num_list.begin(), num_list.begin() + n);
    
    v1.insert(v1.end(), v2.begin(), v2.end());
    
    return v1;
}