#include <bits/stdc++.h>

using namespace std;

void upper(string& str) {
    for (auto& x : str) {
        x = toupper(x);
    }
}

void lower(string& str) {
    for (auto& x : str) {
        x = tolower(x);
    }
}

vector<string> solution(vector<string> strArr) {
    for (int i = 0; i < strArr.size(); i++) {
        if ((i & 1) == 1) upper(strArr[i]);
        else lower(strArr[i]);
    }
    
    return strArr;
}