#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, tmp;
	string token;
	cin >> n >> m;
	unordered_map<int, string> numToStr;
	unordered_map<string, int> strToNum;
	
	for (int i = 1; i <= n; i++) {
		cin >> token;
		numToStr.insert({i, token});
		strToNum.insert({token, i});
	}

	for (int i = 0; i < m; i++) {
		cin >> token;
		
		if (isdigit(token[0])) {
			tmp = stoi(token);
			cout << numToStr[tmp] << "\n";
		} else {
			cout << strToNum[token] << "\n";
		}
	}
	
	return 0;
}