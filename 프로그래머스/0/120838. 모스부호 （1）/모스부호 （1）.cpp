#include <bits/stdc++.h>

using namespace std;

map<string, string> mapp;
void putDataIntoMap() {
    mapp[".-"] = "a";
    mapp["-..."] = "b";
    mapp["-.-."] = "c";
    mapp["-.."] = "d";
    mapp["."] = "e";
    mapp["..-."] = "f";
    mapp["--."] = "g";
    mapp["...."] = "h";
    mapp[".."] = "i";
    mapp[".---"] = "j";
    mapp["-.-"] = "k";
    mapp[".-.."] = "l";
    mapp["--"] = "m";
    mapp["-."] = "n";
    mapp["---"] = "o";
    mapp[".--."] = "p";
    mapp["--.-"] = "q";
    mapp[".-."] = "r";
    mapp["..."] = "s";
    mapp["-"] = "t";
    mapp["..-"] = "u";
    mapp["...-"] = "v";
    mapp[".--"] = "w";
    mapp["-..-"] = "x";
    mapp["-.--"] = "y";
    mapp["--.."] = "z";
}

string solution(string letter) {
    putDataIntoMap();
    string answer = "";
    vector<string> vec;
    
    auto start = 0;
    auto end = letter.find(" ");
    
    // 1. 공백 기준으로 split
    while (end != string::npos) {
        vec.push_back(letter.substr(start, end - start));
        start = end + 1;
        end = letter.find(" ", start);
    }
    vec.push_back(letter.substr(start));
    
    // 2. switch
    for (string str : vec) {
        answer += mapp[str];
    }
    
    return answer;
}