#include <string>
using namespace std;

string solution(string my_string, string overwrite_string, int s) {
    my_string.erase(s, overwrite_string.size());
    my_string.insert(s, overwrite_string);
    return my_string;
}