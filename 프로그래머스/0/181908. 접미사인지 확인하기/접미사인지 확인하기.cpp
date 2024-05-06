#include <bits/stdc++.h>

using namespace std;

int solution(string my_string, string is_suffix) {
    int my_len = my_string.size();
    int suf_len = is_suffix.size();
    
    if (my_len < suf_len) return 0;
    
    string suffix = my_string.substr(my_len - suf_len);
    
    if (suffix == is_suffix) return 1;
    return 0;
}