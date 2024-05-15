#include <string>

using namespace std;

string solution(string n_str) {
    // 문자열을 숫자로 바꾸었다가 다시 문자열로
    return to_string(stoi(n_str));
}