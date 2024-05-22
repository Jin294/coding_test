#include <string>

using namespace std;

string solution(string my_string, string letter) {
    auto it = my_string.find(letter);
    
    while (it != string::npos) {
        my_string.replace(it, letter.size(), "");
        it = my_string.find(letter);
    }
    
    return my_string;
}