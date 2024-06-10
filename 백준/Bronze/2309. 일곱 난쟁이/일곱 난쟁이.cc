#include <bits/stdc++.h>

using namespace std;

int main() {
	vector<int> height(9, 0);
	vector<bool> visited(9, false);
	
	int num;
	for (int i = 0; i < 9; i++) {
		cin >> height[i];
	}
	sort(height.begin(), height.end());
	int sum = accumulate(height.begin(), height.end(), 0);

    bool flag = false;
	for (int i = 0; i < 9; i++) {
		sum -= height[i];
		for (int j = i + 1; j < 9; j++) {
			sum -= height[j];

			if (sum == 100) {
				visited[i] = true;
				visited[j] = true;
				flag = true;
			}
			
            if (flag) break;
			sum += height[j];
		}

        if (flag) break;
		sum += height[i];
	}
	
	for (int i = 0; i < 9; i++) {
		if (!visited[i]) cout << height[i] << "\n";
	}

	return 0;
}