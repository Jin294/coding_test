#include <bits/stdc++.h>

using namespace std;

const int LEN = 3001;
// 소수 여부 체크할 배열 만들기
bool isPrime[LEN];

// 3개의 선택된 숫자
vector<int> selected;

// 선택된 숫자들의 집합
set<vector<int>> answer;

// 조합 : 3개의 수를 뽑는다.
void combination(int now, int sum, int idx, vector<int>& nums) {
    if (now == 3) {
        if (isPrime[sum]) {
            // 단순히 합이 소수인게 아니라, 숫자 3개가 모두 달라야함
            answer.insert(selected);
        }
        return;
    }
    
    for (int i = idx; i < nums.size(); i++) {
        selected.push_back(nums[i]);
        combination(now + 1, sum + nums[i], i + 1, nums);
        selected.pop_back();
    }
}

int solution(vector<int> nums) {
    // 정렬 필수!
    sort(nums.begin(), nums.end());
    
    // isPrime을 true로 초기화한다
    fill(isPrime, isPrime + LEN, true);    
    
    // 0과 1은 소수가 아니므로 false 처리
    isPrime[0] = isPrime[1] = false;
    
    // 소수 필터링(에라토스테네스의 체)
    for (int i = 2; i * i < LEN; i++) {
        for (int j = i * i; j < LEN; j += i) {
            isPrime[j] = false;
        }
    }
    
    // 재귀함수로 숫자 3개 뽑기 (조합)
    for (int i = 0; i < nums.size(); i++) {
        combination(0, 0, i, nums);
    }
    
    // 숫자 3개의 합의 개수만큼 리턴
    return answer.size();
}