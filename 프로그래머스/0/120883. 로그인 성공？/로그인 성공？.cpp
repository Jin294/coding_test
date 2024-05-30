#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db) {
    string answer = "";
    
    map<string, string> dict;
    for (auto info : db) {
        dict[info[0]] = info[1];
    }
    
    if (dict[id_pw[0]] == id_pw[1]) return "login";
    else if (dict[id_pw[0]] == "") return "fail";
        
    return "wrong pw";
}