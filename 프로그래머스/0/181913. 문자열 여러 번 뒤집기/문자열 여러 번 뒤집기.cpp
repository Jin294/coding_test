#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {

    for (vector<int> query: queries) {
        int first = query[0];
        int second = query[1];

        reverse(my_string.begin() + first, my_string.begin() + second + 1);
    }
    
    return my_string;
}