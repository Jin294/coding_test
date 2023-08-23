#include <bits/stdc++.h>
using namespace std;
int a[9], sum;
vector<int> v;
pair<int, int> ret;
void solve(){
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < i; ++j) {
            if (sum - a[i] - a[j] == 100) {
                ret = {i, j};
                return;
            }
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    for (int i = 0; i < 9; ++i) {
        cin >> a[i]; sum += a[i];
    }
    // 일곱 난쟁이 판별
    solve();
    // 일곱 난쟁이가 아닌것들은 push하지 않음
    for (int i = 0; i < 9; ++i) {
        if (ret.first == i || ret.second == i) continue;
        v.push_back(a[i]);
    }
    // 오름차순 정렬
    sort(v.begin(), v.end());
    // 한 칸씩 띄워서 출력
    for (int i : v) cout << i << " ";
    return 0;
}