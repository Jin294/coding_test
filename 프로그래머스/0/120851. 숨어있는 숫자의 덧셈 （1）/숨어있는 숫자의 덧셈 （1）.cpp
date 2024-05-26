#include <string>
#include <vector>
#include <numeric>
#include <cctype>

using namespace std;

int solution(string my_string) {
    vector<int> vec;
    
    for (const char& ch : my_string) {
        if (isdigit(ch)) vec.push_back(ch - '0');
    }
    
    return accumulate(vec.begin(), vec.end(), 0);
}