#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    // map<string, string> 으로 uid와 닉네임 연결
    // 큐를 할까 했는데, 그러면 이미 나간 사람의 닉네임이 변경되지 않음
    // record를 돌면서 enter와 leave를 먼저 기록해야할듯하다
    // => map은 정렬되니까, <int, string> 으로 기록하면 되려나?
    // 아니다. 그냥 맵핑하면서 벡터에 기록해두고, 반복문 한 번 더돌면 될듯
    
    vector<vector<string>> tokens;
    // 1. split
    for (string r : record) {
        vector<string> tmp;
        auto start = 0;
        auto end = r.find(" ");
        
        while (end != string::npos) {
            tmp.push_back(r.substr(start, end - start));
            start = end + 1;
            end = r.find(" ", start);
        }
        
        if (start != 0) {
            tmp.push_back(r.substr(start));
        }
        
        tokens.push_back(tmp);
    }    
    
    // 2. uid와 닉네임 맵핑 & 닉네임 변경
    unordered_map<string, string> users;
    for (auto t : tokens) {
        if (t[0] != "Leave") {
            users[t[1]] = t[2];
        }
    }  
  
    // 3. 기록된 입출력을 기반으로 메시지 출력
    const string ENTER = "님이 들어왔습니다.";
    const string LEAVE = "님이 나갔습니다.";
    
    for (auto t : tokens) {
        if (t[0] == "Enter") {
            answer.push_back(users[t[1]] + ENTER);
        } else if (t[0] == "Leave") {
            answer.push_back(users[t[1]] + LEAVE);
        }
    }
    
    return answer;
}