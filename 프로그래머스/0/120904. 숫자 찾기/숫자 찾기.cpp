#include <bits/stdc++.h>

using namespace std;

int solution(int num, int k) {
    auto it = to_string(num).find(to_string(k));
    if (it != -1) it++;
    return it;
}