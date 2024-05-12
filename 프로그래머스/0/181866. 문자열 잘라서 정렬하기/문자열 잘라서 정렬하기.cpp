#include <bits/stdc++.h>

using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;
    
    auto start = 0;
    auto end = myString.find("x");
    string token;
    
    while (end != string::npos) {
        token = myString.substr(start, end - start);
        if (token != "") answer.push_back(token);
        start = end + 1;
        end = end = myString.find("x", start);
    }
    token = myString.substr(start);
    if (token != "") answer.push_back(token);
    
    sort(answer.begin(), answer.end());
    
    return answer;
}