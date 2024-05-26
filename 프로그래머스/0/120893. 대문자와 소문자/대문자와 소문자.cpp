#include <bits/stdc++.h>

using namespace std;

string solution(string my_string) {
    for (char& x : my_string) {
        if (x >= 'a' && x <= 'z') {
            x = toupper(x);
        } else {
            x = tolower(x);
        }
    }
    
    return my_string;
}