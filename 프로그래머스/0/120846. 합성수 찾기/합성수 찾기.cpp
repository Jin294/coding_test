#include <bits/stdc++.h>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    for (int num = 4; num <= n; num++) {
        double sqrtN = sqrt(num);
        int count = 0;
        for (int i = 1; i <= sqrtN; i++) {
            if (num % i == 0) count += 2;
        }

        int sqrtInt = (int) sqrtN;
        if (sqrtInt * sqrtInt == num) count++;

        if (count >= 3) {
            answer++;
        }
    }
    
    return answer;
}