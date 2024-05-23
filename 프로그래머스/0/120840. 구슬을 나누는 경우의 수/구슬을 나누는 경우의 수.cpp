using namespace std;

// 조합(combination)
int solution(int balls, int share) {
    if (balls == share) return 1;
    
    // 조합(nCr = n! / ((n-r)! * r!))
    int n = balls;
    int r = balls - share > share ? share : balls - share;
    
    unsigned long long answer = 1;
    for (int i = 1; i <= r; i++) {
        answer *= n - r + i;
        answer /= i;
    }
    
    return answer;
}