#include <bits/stdc++.h>

using namespace std;

string solution(string polynomial) {
    // 1. 공백을 구분삼아 나누기
    vector<string> tokens;
    auto start = 0;
    auto end = polynomial.find(" + ");
    
    while (end != string::npos) {
        tokens.push_back(polynomial.substr(start, end - start));
        start = end + 3;
        end = polynomial.find(" + ", start);
    }
    
    tokens.push_back(polynomial.substr(start));
    
    // 2. 계산
    int coef = 0;
    int constant = 0;
    
    for (string token : tokens) {
        size_t len = token.size();
        if (token[len - 1] == 'x') {
            if (len == 1) coef++;
            else coef += stoi(token.substr(0, len - 1));
        } else {
            constant += stoi(token);
        }
    }

    string first = coef > 1 ? (to_string(coef) + "x") : ((coef == 1) ? "x" : "") ;
    string second = constant > 0 ? to_string(constant) : "";
    
    if (first.size() > 0 && second.size() > 0) return first + " + " + second;
    else if (first.size() == 0) return second;
    else if (second.size() == 0) return first;
    return "";
}