#include <bits/stdc++.h>

using namespace std;

vector<int> nums = {0, 1, 2, 3};
vector<vector<int>> combs;

void makePermutation(int n, int r, int depth, vector<int> b) {
    if (r == depth) {
        combs.push_back(b);
        return;
    }
    
    for (int i = depth; i < n; i++) {
        b.push_back(nums[i]);
        makePermutation(n, r, depth + 1, b);
        b.pop_back();
    }
}

int solution(vector<vector<int>> dots) {
    // 4개 중에 2개 뽑는 조합(순서 x)
    vector<int> b;
    makePermutation(4, 4, 0, b);
    
    int answer = 0;

    for (auto p : combs) {
        for (auto num : p) {
            cout << num << " ";
        }
        cout << endl;
    }
    
    // 조합 저장한 순서대로 기울기 비교
//     for (auto p : combs) {
//         vector<int> first = dots[p[0]];
//         vector<int> second = dots[p[1]];
        
//         cout << first[0] << " " << first[1] << endl;
//         cout << second[0] << " " << second[1] << endl;
//     }
    
    return answer;
}