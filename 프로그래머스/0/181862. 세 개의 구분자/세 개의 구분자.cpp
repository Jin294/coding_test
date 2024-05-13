#include <string>
#include <vector>

using namespace std;

vector<string> solution(string myStr) {
    vector<string> answer;
    
    string tmp;
    for (int i = 0; i < myStr.size(); i++) {
        if (myStr[i] != 'a' && myStr[i] != 'b' && myStr[i] != 'c') {
            tmp += myStr[i];
        } else if (tmp != "") {
            answer.push_back(tmp);
            tmp = "";
        }
    }
    
    if (tmp != "") {
        answer.push_back(tmp);
    }
    
    if (answer.empty()) answer.push_back("EMPTY");
    return answer;
}