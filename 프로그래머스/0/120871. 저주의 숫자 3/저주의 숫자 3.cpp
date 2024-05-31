#include <bits/stdc++.h>

using namespace std;

bool using3(int num) {
    while (num > 0) {
        if (num % 10 == 3) {
            return true;
        }
        num /= 10;
    }
    
    return false;
}

int solution(int n) {
    int num = 0;
    for (int i = 0; i < n; i++) {
        num++;
        
        while ((num % 3 == 0) || using3(num)) num++;
    }
    
    return num;
}