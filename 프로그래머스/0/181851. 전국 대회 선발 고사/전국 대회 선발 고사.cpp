#include <bits/stdc++.h>

using namespace std;

// pair의 대소를 비교할 커스텀 sort함수 
bool compare(pair<int, int> one, pair<int, int> two) {
    return one.first < two.first;
}

int solution(vector<int> rank, vector<bool> attendance) {
    vector<pair<int, int>> list;
    // 참석 가능한 사람들만 따로 추려내기 -> pair로
    for (int i = 0; i < rank.size(); i++) {
        if (attendance[i]) list.push_back({rank[i], i});
    }
    
    // pair가 들어간 list를 등수(first) 기준으로 오름차순 정렬
    sort(list.begin(), list.end(), compare);
        
    return list[0].second * 10000 + list[1].second * 100 + list[2].second;
}