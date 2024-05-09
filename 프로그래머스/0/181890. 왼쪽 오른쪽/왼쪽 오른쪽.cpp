#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> str_list) {
    for (int i = 0; i < str_list.size(); i++) {
        // 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트
        if (str_list[i] == "l") return vector<string> (str_list.begin(), str_list.begin() + i);
        
        // 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트
        else if (str_list[i] == "r") return vector<string> (str_list.begin() + (i + 1), str_list.end());
    }
    
    // "l"이나 "r"이 없다면 빈 리스트
    return {};
}