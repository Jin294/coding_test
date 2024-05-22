#include <string>

using namespace std;

string solution(int age) {
    string num_str = to_string(age);
    for (char& ch : num_str) ch += 'a' - '0';
    return num_str;
}