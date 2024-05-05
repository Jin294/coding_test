#include <string>
#include <vector>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    
    for (int i = 0; i < my_strings.size(); i++) {
        int first = parts[i][0];
        int second = parts[i][1];
        
        answer += my_strings[i].substr(first, second - first + 1);
    }
    return answer;
}