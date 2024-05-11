#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    if (num_list.size() >= 11) return accumulate(num_list.begin(), num_list.end(), 0);
    int answer = 1;
    for (auto& num : num_list) answer *= num;
    return answer;
}