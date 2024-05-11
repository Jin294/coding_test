#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, string alp) {
    for (auto& x : my_string) {
        if (x == alp[0]) x = toupper(x);
    }
    return my_string;
}