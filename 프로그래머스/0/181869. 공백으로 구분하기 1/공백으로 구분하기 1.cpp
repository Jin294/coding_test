#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    
    auto start = 0;
    auto end = my_string.find(" ");
    while (end != string::npos) {
        answer.push_back(my_string.substr(start, end - start));
        start = end + 1;
        end = my_string.find(" ", start);
    }
    answer.push_back(my_string.substr(start));
    
    return answer;
}