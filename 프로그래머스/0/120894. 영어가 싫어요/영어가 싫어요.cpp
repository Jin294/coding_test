#include <bits/stdc++.h>

using namespace std;

long long solution(string numbers) {
    vector<string> list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    for (int i = 0; i < list.size(); i++) numbers = regex_replace(numbers, regex(list[i]), to_string(i));
    
    return stoll(numbers.c_str());
}