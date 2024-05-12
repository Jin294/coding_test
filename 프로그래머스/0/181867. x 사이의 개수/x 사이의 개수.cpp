#include <string>
#include <vector>

using namespace std;

vector<int> solution(string myString) {
    vector<int> answer;
    
    auto start = 0;
    auto end = myString.find("x");
    
    while (end != string::npos) {
        answer.push_back(myString.substr(start, end - start).size());
        start = end + 1;
        end = end = myString.find("x", start);
    }
    answer.push_back(myString.substr(start).size());
    
    return answer;
}