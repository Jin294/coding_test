#include <string>

using namespace std;

string solution(string code) {
    int mode = 0;
    string answer = "";
    for (int idx = 0; idx < code.length(); idx++) {
        if (mode == 0) {
            if (code[idx] == '1') {
                mode = 1;
            } else {
                if (idx % 2 == 0) {
                    answer += code[idx];
                }                
            }
        } else if (mode == 1) {
            if (code[idx] == '1') {
                mode = 0;
            } else {
                if (idx % 2 == 1) {
                    answer += code[idx];
                }                
            }
        }
    }
    
    return answer.length() == 0 ? "EMPTY" : answer;
}