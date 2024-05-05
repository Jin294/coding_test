#include <string>

using namespace std;

string solution(string my_string, int n) {
    int len = my_string.size() - n;
    return my_string.substr(len, n);
}