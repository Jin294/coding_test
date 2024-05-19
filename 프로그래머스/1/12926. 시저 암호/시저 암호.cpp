#include <string>

using namespace std;

string solution(string s, int n) {
    for (char& ch : s) {
        // 알파벳일때만 계산
        if (!isalpha(ch)) continue;
        
        // 재조정
        char base = islower(ch) ? 'a' : 'A';
        ch = base + (ch - base + n) % 26;
    }
    
    return s;
}