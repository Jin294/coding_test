#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    
    for (int i = 0; i < indices.size(); i++) {
        my_string[indices[i]] = '!';
    }
    
    for (char x : my_string)  {
        if (isalpha(x))  answer += x;
    }
    
    return answer;
}