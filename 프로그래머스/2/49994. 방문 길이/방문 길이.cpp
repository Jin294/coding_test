#include <bits/stdc++.h>

using namespace std;

// 주어진 범위를 벗어나는지 검사
bool checkBoundary(int row, int col) {
    return row >= -5 && row <= 5 && col >= -5 && col <= 5;
}

int solution(string dirs) {
    // 글자에 따른 방향을 매핑하는 directions
    unordered_map<char, pair<int, int>> directions {
        {'U', {-1, 0}},
        {'D', {1, 0}},
        {'R', {0, 1}},
        {'L', {0, -1}}
    };
    
    int row = 0;
    int col = 0;
    
    // 이동 경로를 담는 set; (before_y, before_x, after_y, after_x)
    set<pair<pair<int, int>, pair<int, int>>> records;

    for (char dir : dirs) {
        auto [dr, dc] = directions[dir];
        
        // 일단 이동 우선
        int nr = row + dr;
        int nc = col + dc;
        
        if (checkBoundary(nr, nc)) {
            // 이동한 값이 범위 안에 속한다면 양방향 경로를 모두 기록
            records.insert({{row, col}, {nr, nc}});
            records.insert({{nr, nc}, {row, col}});
            
            // 이동한 값으로 업데이트
            row = nr;
            col = nc;
        }
    }
    
    // 유일한 경로의 수를 반환
    return records.size() / 2;
}
