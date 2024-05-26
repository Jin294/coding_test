#include <string>
#include <vector>
#include <numeric>

using namespace std;

int solution(string my_string) {
    vector<int> vec;
    
    for (const char& ch : my_string) {
        if (ch >= '0' && ch <= '9') vec.push_back(ch - '0');
    }
    
    return accumulate(vec.begin(), vec.end(), 0);
}