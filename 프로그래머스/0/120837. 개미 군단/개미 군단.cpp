using namespace std;

int solution(int hp) {
    int cnt = 0;
    int arr[] = {5, 3, 1};
    
    for (int atk : arr) {
        cnt += hp / atk;
        hp %= atk;
    }
    
    return cnt;
}