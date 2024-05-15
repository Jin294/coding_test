#include <string>

using namespace std;

string solution(string n_str) {
    int idx = -1;
    for (int i = 0; i < n_str.size(); i++) {
        if (n_str[i] == '0') idx = i;
        else break;
    }
    
    return idx == -1 ? n_str : n_str.substr(idx + 1);
}