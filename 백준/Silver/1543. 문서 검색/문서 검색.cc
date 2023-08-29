#include <bits/stdc++.h>
using namespace std;
string s, a;
int cnt = 0;
int main(){
  getline(cin, s);
  getline(cin, a);

  int idx = s.find(a);
  while (idx != string::npos) {
    idx = s.find(a, idx + a.size());
    cnt++;
  }
  cout << cnt;
}