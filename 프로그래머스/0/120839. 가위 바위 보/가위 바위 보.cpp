#include <string>

using namespace std;

string solution(string rsp) {
    string answer = "";
    
    for (char ch : rsp) {
        if (ch == '2') answer += "0";
        else if (ch == '0') answer += "5";
        else answer += "2";
    }
    
    return answer;
}