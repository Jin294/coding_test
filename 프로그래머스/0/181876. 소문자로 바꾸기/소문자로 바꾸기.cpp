#include <bits/stdc++.h>

using namespace std;

string solution(string myString) {
    for (auto& x : myString) x = tolower(x);
    return myString;
}