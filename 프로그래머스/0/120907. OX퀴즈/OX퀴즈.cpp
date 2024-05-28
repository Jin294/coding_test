#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> answer;
    
    for (string q : quiz) {
        vector<string> tokens;

        auto start = 0;
        auto end = q.find(" ");
        
        // split
        while (end != string::npos) {
            tokens.push_back(q.substr(start, end - start));
            start = end + 1;
            end = q.find(" ", start);
        }
        tokens.push_back(q.substr(start));
        
        int first = stoi(tokens[0]);
        int second = stoi(tokens[2]);
        int res = stoi(tokens[4]);
        
        if (tokens[1] == "+") {
            if (first + second == res) answer.push_back("O");
            else answer.push_back("X");
        } else {
            if (first - second == res) answer.push_back("O");
            else answer.push_back("X");
        }
    }
    
    return answer;
}