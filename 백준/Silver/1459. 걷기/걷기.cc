#include <bits/stdc++.h>
using namespace std;
long long x, y, w, s, one, two, three;
int main(){
  cin >> x >> y >> w >> s;

  // 수평이동
  one = (x + y) * w;
  
  // 대각선이동
  if ((x + y) % 2 == 0) {
    // 짝수
    two = max(x, y) * s;
  } else {
    // 홀수
    two = (max(x, y) - 1) * s + w;
  }
  
  // 대각선 + 수평이동
  three = min(x, y) * s + (max(x, y) - min(x, y)) * w;
  cout << min(one, min(two, three));
}