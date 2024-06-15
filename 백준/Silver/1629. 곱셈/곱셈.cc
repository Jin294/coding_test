#include <bits/stdc++.h>

using namespace std;

int a, b, c;

long long calc(long long num) {
    if (num == 1) return a % c;

    long long res = calc(num / 2) % c;
    res = res * res % c;

    if (num % 2 != 0) res = res * a % c;

    return res;
}

int main() {
    cin >> a >> b >> c;
    cout << calc(b);
	return 0;
}