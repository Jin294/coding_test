#include <bits/stdc++.h>

using namespace std;

int main() {
	string s;
    getline(cin, s);
    
    for (char& x : s) {
        if (isupper(x)) {
            if (!isupper(x + 13)) x = x + 13 - 26;
            else x += 13;
        } else if (islower(x)) {
            if (!islower(x + 13)) x = x + 13 - 26;
            else x += 13;
        }
    }

    cout << s;
	return 0;
}