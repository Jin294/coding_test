#include<cmath>

using namespace std;

int times(int a, int b, int c, int x) {
    return (int)pow(a, x) + (int)pow(b, x) + (int)pow(c, x);
}

int solution(int a, int b, int c) {
    int one = times(a, b, c, 1);
    int two = times(a, b, c, 2);
    int three = times(a, b, c, 3);
    
    if (a != b && b != c && a != c) {
        return one;
    }
    
    if (a == b && b == c && a == c) {
        return one * two * three;
    }
    
    return one * two;
}