#include <bits/stdc++.h>

using namespace std;

int solution(int num, int k) {
    auto it = to_string(num).find(to_string(k)) + 1;
    return it ? it : -1;
}