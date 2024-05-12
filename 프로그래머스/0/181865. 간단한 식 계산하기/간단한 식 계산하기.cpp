#include <bits/stdc++.h>

using namespace std;

int solution(string binomial) {
    // 공백 기준으로 split
    vector<string> result;
    
    auto start = 0;
    auto end = binomial.find(" ");
    string token;
    
    while (end != string::npos) {
        token = binomial.substr(start, end - start);
        if (token != "") result.push_back(token);
        start = end + 1;
        end = binomial.find(" ", start);
    }
    token = binomial.substr(start);
    if (token != "") result.push_back(token);
    
    // 숫자문자열을 숫자로바꾼다
    int first = atoi(result[0].c_str());
    int second = atoi(result[2].c_str());
    
    // 계산
    switch(result[1][0]) {
        case '+':
            return first + second;
        case '-':
            return first - second;
        case '*':
            return first * second;
    }
    
    return 0;
}