#include <bits/stdc++.h>
using namespace std;
int n, m, arr[15001], totalCount;
int main(){
  cin >> n >> m;
  if (m > 200000) cout << 0;
  else {
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    // copy(arr, arr + n, ostream_iterator<int>(cout, " "));
    int lt = 0, rt = n - 1;
    while (lt < rt) {
      if (arr[lt] + arr[rt] > m) {
        rt--;
      } else if (arr[lt] + arr[rt] < m) {
        lt++;
      } else {
        lt++; rt--; totalCount++;
      }
    }
    cout << totalCount;
  }
}