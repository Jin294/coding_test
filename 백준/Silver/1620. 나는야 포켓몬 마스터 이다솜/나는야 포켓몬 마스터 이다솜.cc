#include <bits/stdc++.h>
using namespace std;
int n ,m;
string s;
map<string, int> names;
map<int, string> indexes;
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    names[s] = i;
    indexes[i] = s;
  }
  for (int i = 0; i < m; i++) {
    cin >> s;
    if (atoi(s.c_str()) == 0) { // 문자가 들어올 때
      cout << names[s] << "\n";
    } else { // 숫자가 들어올 때
      cout << indexes[atoi(s.c_str())] << "\n";
    }
  }
}