#include <bits/stdc++.h>

using namespace std;

int solution(string my_string) {
    vector<string> vec;
    int answer = 0;
    
    int start = 0;
    bool flag = false;
    for (int i = 0; i < my_string.size(); i++) {
        if (isdigit(my_string[i]) && !flag) {
            flag = true;
            start = i;
        } else if (flag && !isdigit(my_string[i])) {
            flag = false;
            vec.push_back(my_string.substr(start, i - start));
        }
    }
    
    if (flag) vec.push_back(my_string.substr(start));
    
    for (auto it : vec) answer += stoi(it);
    
    return answer;
}