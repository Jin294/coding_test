#include <bits/stdc++.h>

using namespace std;

int solution(string s) {
    vector<string> vec;
    auto start = 0;
    auto end = s.find(" ");
    
    // 공백 기준으로 분할하기
    while (end != string::npos) {
        vec.push_back(s.substr(start, end - start));
        start = end + 1;
        end = s.find(" ", start);
    }
    vec.push_back(s.substr(start));
    
    int answer = 0;
    for (int i = 0; i < vec.size(); i++) {
        if (isalpha(vec[i][0])) {
            answer -= atoi(vec[i - 1].c_str());
        } else {
            answer += atoi(vec[i].c_str());
        }
    }
    
    return answer;
}