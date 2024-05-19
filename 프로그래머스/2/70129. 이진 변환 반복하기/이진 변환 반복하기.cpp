#include <bits/stdc++.h>

using namespace std;

string toBinary(int num) {
    string str;
    while (num > 0) {
        if (num % 2 == 1) str += "1";
        else str += "0";
        num >>= 1;
    }
            
    // 문자열 뒤집기
    reverse(str.begin(), str.end());
    return str;
}

vector<int> solution(string s) {
    int cnt = 0;
    int zero = 0;
    while (s != "1") {
        // 0빼기
        string tmp;
        for (char& x : s) {
            if (x == '0') zero++;
            else tmp += x;
        }

        cnt++;

        // s의 길이만큼 2진수로 만들기
        s = toBinary(tmp.size());
    }
    
    return {cnt, zero};
}