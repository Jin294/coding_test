#include <bits/stdc++.h>

using namespace std;

string solution(string myString) {
    for (char& x : myString) {
        if (x == 'a') x = 'A';
        else if (x != 'A' && (x > 'A' && x <= 'Z')) x = tolower(x); 
    }
    
    return myString;
}