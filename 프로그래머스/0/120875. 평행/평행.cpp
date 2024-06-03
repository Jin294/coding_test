#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> dots) {
    vector<int> p1 = dots[0];
    vector<int> p2 = dots[1];
    vector<int> p3 = dots[2];
    vector<int> p4 = dots[3];
    
    double slope1 = abs(p2[1] - p1[1]) * 1.0 / abs(p2[0] - p1[0]);
    double slope2 = abs(p4[1] - p3[1]) * 1.0 / abs(p4[0] - p3[0]);

    if (slope1 == slope2) return 1;
    
    double slope3 = abs(p3[1] - p1[1]) * 1.0 / abs(p3[0] - p1[0]);
    double slope4 = abs(p4[1] - p2[1]) * 1.0 / abs(p4[0] - p2[0]);

    if (slope3 == slope4) return 1;
    
    double slope5 = abs(p4[1] - p1[1]) * 1.0 / abs(p4[0] - p1[0]);
    double slope6 = abs(p3[1] - p2[1]) * 1.0 / abs(p3[0] - p2[0]);

    if (slope5 == slope6) return 1;
    
    return 0;
}