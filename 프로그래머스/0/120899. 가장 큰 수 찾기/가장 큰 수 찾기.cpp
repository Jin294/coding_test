#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array) {
    int maxVal = 0;
    int maxIdx = 0;
    
    for (int i = 0; i < array.size(); i++) {
        if (maxVal < array[i]) {
            maxVal = array[i];
            maxIdx = i;
        }
    }
    
    return {maxVal, maxIdx};
}