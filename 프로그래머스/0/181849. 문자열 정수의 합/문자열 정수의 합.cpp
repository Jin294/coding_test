#include <string>

using namespace std;

int solution(string num_str) {
    int answer = 0;
    
    for (char x : num_str) answer += atoi(string(1, x).c_str());
    
    return answer;
}