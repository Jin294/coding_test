#include <bits/stdc++.h>
using namespace std;
int n, loc;
string s, ori_s, pre, suf;
int main() {
  cin >> n >> ori_s;
  // 별표 위치 찾기
  int pos = ori_s.find('*');
  pre = ori_s.substr(0, pos);
  suf = ori_s.substr(pos + 1);
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (pre.size() + suf.size() > s.size()) {
      cout << "NE" << endl;
    } else {
      if (pre == s.substr(0, pre.size()) && suf == s.substr(s.size() - suf.size())) cout << "DA" << endl;
      else cout << "NE" << endl;
    }
  }
}