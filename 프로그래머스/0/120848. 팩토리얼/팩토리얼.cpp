using namespace std;

int solution(int n) {
    if (n == 1) return 1;
    
    int res = 1;
    for (int i = 2; i <= 10; i++) {
        if (res * i > n) return i - 1;
        res *= i;
    }
    
    return 10;
}