#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    
    auto start = 0;
    auto end = my_string.find(" ");
    while (end != string::npos) {
        string tmp = my_string.substr(start, end - start);
        if (tmp.size() > 0) answer.push_back(tmp);
        start = end + 1;
        end = my_string.find(" ", start);
    }
    if (my_string.substr(start).size() > 0) answer.push_back(my_string.substr(start));
    
    return answer;
}