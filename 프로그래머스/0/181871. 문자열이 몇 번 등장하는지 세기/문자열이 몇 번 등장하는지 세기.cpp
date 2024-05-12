#include <string>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    
    size_t idx = myString.find(pat);
    while (idx != string::npos) {
        answer++;
        myString = myString.substr(idx + 1);
        idx = myString.find(pat);
    }
    
    return answer;
}