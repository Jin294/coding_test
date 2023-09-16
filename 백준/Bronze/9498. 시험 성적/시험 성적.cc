#include <bits/stdc++.h>
using namespace std;
int main() {
  int score;
  char x;
  cin >> score;
  if (score >= 90) x = 'A';
  else if (score >= 80) x = 'B';
  else if (score >= 70) x = 'C';
  else if (score >= 60) x = 'D';
  else x = 'F';
  cout << x;
}