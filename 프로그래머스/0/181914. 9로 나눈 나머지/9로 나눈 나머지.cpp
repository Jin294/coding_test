#include <string>

using namespace std;

int solution(string number) {
    int sum = 0;
    for (char x : number) sum += x - '0';
    return sum % 9;
}