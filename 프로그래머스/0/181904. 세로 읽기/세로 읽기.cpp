#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, int m, int c) {
    // m글자씩 자른다 => vector에 저장
    vector<string> list;
    for (int i = 0; i < my_string.size(); i+=m) {
        if (i + m >= my_string.size()) list.push_back(my_string.substr(i));
        else list.push_back(my_string.substr(i, m));
    }
    
    string answer = "";
    
    // 세로로 c번째 열의 글자만 추출
    for (string str : list) answer += str[c - 1];
    
    return answer;
}