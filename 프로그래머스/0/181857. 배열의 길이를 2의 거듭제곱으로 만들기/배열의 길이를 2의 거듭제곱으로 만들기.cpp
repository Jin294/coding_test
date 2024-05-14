#include <string>
#include <vector>

using namespace std;

int getNum(int len) {
    int num = 1;
    while (num < len) {
        num *= 2;
    }
    return num;
}

vector<int> solution(vector<int> arr) {
    // arr의 길이보다 크거나 같은 2의 제곱수 구하기
    int len = getNum(arr.size());
    if (len == arr.size()) return arr;
    
    // arr의 길이가 len이 될 때 까지, 0을 더해아
    while (arr.size() < len) arr.push_back(0);
    return arr;
}