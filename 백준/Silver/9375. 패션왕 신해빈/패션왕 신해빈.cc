#include <bits/stdc++.h>
using namespace std;
int tc, n;
string kind, name;
int main(){
  cin >> tc;
  for (int i = 0; i < tc; i++) {
    map<string, int> list;
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> name >> kind;
      list[kind]++;
    }
    long long res = 1;
    for (auto x : list) {
      res *= ((long long)x.second + 1);
    }
    res--;
    cout << res << "\n";
  }
}