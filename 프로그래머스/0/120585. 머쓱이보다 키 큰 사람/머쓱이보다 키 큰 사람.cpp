#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> array, int height) {
    return count_if(array.begin(), array.end(), [&](int x){ return x > height; });
}