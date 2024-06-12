#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> nums(n, 0);
    for (int& num : nums) {
        cin >> num;
    }

    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }

    int answer = sum;
    for (int i = 1; i < n - k + 1; i++) {
        sum -= nums[i - 1];
        sum += nums[i + k - 1];
        
        if (answer < sum) answer = sum;
    }
    
    cout << answer;
	return 0;
}