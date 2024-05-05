#include <string>
#include <vector>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    
    for (int i = 0; i < my_strings.size(); i++) {
        auto p = parts[i];
        
        answer += my_strings[i].substr(p[0], p[1] - p[0] + 1);
    }
    return answer;
}