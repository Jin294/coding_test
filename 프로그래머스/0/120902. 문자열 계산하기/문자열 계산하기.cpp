#include <bits/stdc++.h>

using namespace std;

int solution(string str) {
    auto start = 0;
    auto end = str.find(" ");
    vector<string> list;
    while (end != string::npos) {
        list.push_back(str.substr(start, end - start));
        start = end + 1;
        end = str.find(" ", start);
    }
    
    list.push_back(str.substr(start));
    
    int answer = stoi(list[0]);
    for (int i = 1; i < list.size(); i+= 2) {
        if (list[i] == "+") answer += stoi(list[i + 1]);
        else answer -= stoi(list[i + 1]);
    }
    
    return answer;
}