#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, answer = 0, val = 0, tmp = 1;
  cin >> a >> b;
  for (int i = 0; i < 3; i++) {
    val = a * (b % 10);
    cout << val << endl;
    answer += val * tmp;
    tmp *= 10;
    b /= 10;
  }

  cout << answer;
}