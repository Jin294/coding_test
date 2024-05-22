#include <bits/stdc++.h>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    for (int i = 1; i < sqrt(n); i++) {
        if (n % i == 0) answer++;
    }

    int num = sqrt(n);
    if ((int) pow(num, 2) == n) return answer* 2 + 1;
    else return answer * 2;
}