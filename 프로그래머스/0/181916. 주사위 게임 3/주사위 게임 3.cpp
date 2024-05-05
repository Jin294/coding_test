#include <bits/stdc++.h>

using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> nums = {a, b, c, d};
    
    // 오름차순 정렬
    sort(nums.begin(), nums.end());
    
    // 모든 숫자가 같다
    if (nums[0] == nums[3]) return 1111 * nums[0];
    
    // 같은 숫자가 세개인 것이 있다
    if (nums[0] == nums[2] || nums[1] == nums[3]) {
        int answer;
        
        if (nums[0] == nums[2]) answer = 10 * nums[0] + nums[3];
        else answer = 10 * nums[1] + nums[0];
        
        return answer * answer;
    }

    // 같은 숫자가 두 개인 것이 두 케이스 있다.
    if (nums[0] == nums[1] && nums[2] == nums[3]) return (nums[0] + nums[2]) * (abs(nums[0] - nums[2]));
    
    // 같은 숫자가 두 개인 것이 한 케이스 있다.
    if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[3]) {
        if (nums[0] == nums[1]) return nums[2] * nums[3];
        else if (nums[1] == nums[2]) return nums[0] * nums[3]; 
        else return nums[0] * nums[1];
    }
    
    // 모든 숫자가 다르다
    return *min_element(nums.begin(), nums.end());
}