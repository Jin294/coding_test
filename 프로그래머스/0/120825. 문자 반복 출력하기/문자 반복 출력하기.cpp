#include <string>

using namespace std;

string solution(string my_string, int n) {
    string answer = "";
    
    for (char ch : my_string) answer += string(n, ch);
        
    return answer;
}