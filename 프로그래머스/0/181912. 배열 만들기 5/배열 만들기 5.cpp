#include <bits/stdc++.h>

using namespace std;

// substr 사용하는 문제

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    
    for (string str : intStrs) {
        int slicedNum = atoi(str.substr(s, l).c_str());
        
        if (slicedNum > k) answer.push_back(slicedNum);
    }
    
    return answer;
}