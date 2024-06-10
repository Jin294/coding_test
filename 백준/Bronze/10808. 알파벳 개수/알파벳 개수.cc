#include <bits/stdc++.h>

using namespace std;

int main() {
	string str;
	cin >> str;
	
	vector<int> alphaCnt(26, 0);
	
	for (char x : str) alphaCnt[x - 'a']++;
	for (int cnt : alphaCnt) cout << cnt << " ";
	
	return 0;
}