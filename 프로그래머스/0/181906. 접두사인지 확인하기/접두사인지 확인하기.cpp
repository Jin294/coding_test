#include <string>

using namespace std;

int solution(string my_string, string is_prefix) {
    int my_len = my_string.size();
    int pre_len = is_prefix.size();
    
    if (my_len < pre_len) return 0;
    
    if (my_string.substr(0, pre_len) == is_prefix) return 1;
    return 0;
}