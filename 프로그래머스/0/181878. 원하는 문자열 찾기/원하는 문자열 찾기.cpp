#include <bits/stdc++.h>

using namespace std;

int solution(string myString, string pat) {
    if (toupper(myString).find(toupper(pat)) != string::npos) return 1;
    return 0;
}