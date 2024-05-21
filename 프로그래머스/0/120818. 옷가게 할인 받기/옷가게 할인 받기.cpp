using namespace std;

int solution(int price) {
    if (price >= 500'000) return price * 0.8;
    else if (price >= 300'000) return price * 0.9;
    else if (price >= 100'000) return price * 0.95;
    return price;
}