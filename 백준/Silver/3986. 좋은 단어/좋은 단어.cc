#include <bits/stdc++.h>

using namespace std;

int main() {
	// 데이터 입력
	int n;
	string token;
	cin >> n;
	vector<char> vec;
	
	int answer = 0;
	// n만큼 반복
	while (n-- > 0) {
		// 단어 입력
		cin >> token;
		for (char x : token) {
			if (!vec.empty() && vec.back() == x) {
				// 문자와 벡터 끝문자가 같으면 => pop
				vec.pop_back();
			} else {
				// 아니면 넣음
				vec.push_back(x);
			}
		}
		
		// 벡터가 비어있다 => 조건 만족
		if (vec.empty()) answer++;
		else vec.clear();
	}

	cout << answer;

	return 0;
}