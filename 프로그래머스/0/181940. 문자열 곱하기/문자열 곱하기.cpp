#include <string>

using namespace std;

string solution(string my_string, int k) {
    string answer = "";
    while (k-- > 0) answer += my_string;
    return answer;
}