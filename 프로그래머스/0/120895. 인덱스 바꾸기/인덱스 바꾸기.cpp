#include <string>

using namespace std;

string solution(string str, int num1, int num2) {
    char tmp = str[num1];
    str[num1] = str[num2];
    str[num2] = tmp;
    
    return str;
}