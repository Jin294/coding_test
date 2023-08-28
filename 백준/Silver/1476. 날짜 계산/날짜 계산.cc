#include <bits/stdc++.h>
using namespace std;
int e, s, d, one, two, three, sum;
int main(){
  cin >> e >> s >> d;
  while (true) {
    one++;
    if (one == 16) one = 1;
    two++;
    if (two == 29) two = 1;
    three++;
    if (three == 20) three = 1;
    sum++;

    if ((e == one) && (s == two) && (d == three)) break;
  }
  cout << sum;
}