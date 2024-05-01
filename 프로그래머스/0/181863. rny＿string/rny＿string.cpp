#include <string>
#include <vector>

using namespace std;

string solution(string rny_string) {
    string answer = "";
    
    for (char x : rny_string) {
        if (x == 'm') answer += "rn";
        else answer += x;
    }
    
    return answer;
}