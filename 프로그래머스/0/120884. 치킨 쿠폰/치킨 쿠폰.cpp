using namespace std;

int solution(int chicken) {
    int service = 0;
    
    int tmp = chicken / 10;
    while (tmp > 0) {
        chicken %= 10;
        service += tmp;
        chicken += tmp;
        tmp = chicken / 10;
    }
    
    return service;
}