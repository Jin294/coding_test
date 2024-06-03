using namespace std;

int solution(int chicken) {
    int coupon = chicken;
    int service = 0;
    
    int tmp = coupon / 10;
    while (tmp > 0) {
        coupon %= 10;
        service += tmp;
        coupon += tmp;
        tmp = coupon / 10;
    }
    
    return service;
}