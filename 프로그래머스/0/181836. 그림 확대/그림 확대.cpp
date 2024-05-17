#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> answer;

    for (string str : picture) {
        string tmp = "";
        for (char ch : str) {
            for (int i = 0; i < k; i++) {
                tmp += ch;
            }
        }

        for (int i = 0; i < k; i++) answer.push_back(tmp);
    }
    
    return answer;
}