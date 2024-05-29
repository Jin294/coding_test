#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> dots) {
    vector<int> xp, yp;
    
    for (auto dot : dots) {
        xp.push_back(dot[0]);
        yp.push_back(dot[1]);
    }
    
    int minX = *min_element(xp.begin(), xp.end());
    int maxX = *max_element(xp.begin(), xp.end());
    int minY = *min_element(yp.begin(), yp.end());
    int maxY = *max_element(yp.begin(), yp.end());
    
    return (maxX - minX) * (maxY - minY);
}