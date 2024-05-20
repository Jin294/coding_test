using namespace std;

int solution(int slice, int n) {
    if (slice >= n) return 1;
    return n % slice == 0 ? n / slice : n / slice + 1;
}