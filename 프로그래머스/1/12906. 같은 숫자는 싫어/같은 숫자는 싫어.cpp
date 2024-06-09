#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer {arr[0]};

    for (int num : arr) if (num != answer.back()) answer.push_back(num);
    
    return answer;
}