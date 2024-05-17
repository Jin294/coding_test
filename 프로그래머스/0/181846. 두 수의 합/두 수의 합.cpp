#include <bits/stdc++.h>

using namespace std;

string solution(string a, string b) {
    string answer = "";
    
    // a와 b의 길이를 비교해서, 짧은쪽의 앞에 0을 넣는다
    size_t lenA = a.size();
    size_t lenB = b.size();
    
    if (lenA < lenB) {
        a = string(lenB - lenA, '0') + a; // a의 앞에 0을 추가
    } else {
        b = string(lenA - lenB, '0') + b; // b의 앞에 0을 추가
    }
    
    int tmp = 0;
    for (int i = a.size() - 1; i >= 0; i--) {
        int sum = (a[i] - '0') + (b[i] - '0') + tmp;
        
        tmp = sum / 10; // sum 결과에 따른 자릿수 업데이트
        
        answer += ((sum % 10) + '0'); // 문자로 넣는다
    }
    
    if (tmp > 0) answer += (tmp + '0'); // 문자로 넣는다
    
    reverse(answer.begin(), answer.end());
    return answer;
}