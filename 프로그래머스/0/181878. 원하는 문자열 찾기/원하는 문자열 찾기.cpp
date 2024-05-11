#include <bits/stdc++.h>

using namespace std;

void upper(string& str) {
    for (auto& x : str) {
        x = toupper(x);
    }
}

int solution(string myString, string pat) {
    // 대문자로 통일
    upper(myString);
    upper(pat);
    if (myString.find(pat) != string::npos) return 1;
    return 0;
}