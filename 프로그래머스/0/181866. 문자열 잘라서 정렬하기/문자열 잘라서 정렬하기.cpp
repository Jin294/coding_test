#include <bits/stdc++.h>

using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;
    
    auto start = 0;
    auto end = myString.find("x");
    
    while (end != string::npos) {
        if (myString.substr(start, end - start).size() > 0) answer.push_back(myString.substr(start, end - start));
        start = end + 1;
        end = end = myString.find("x", start);
    }
    if (myString.substr(start).size() > 0) answer.push_back(myString.substr(start));
    
    sort(answer.begin(), answer.end());
    
    return answer;
}