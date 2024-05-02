#include <string>
#include <algorithm>

using namespace std;

int solution(int a, int b) {
    return max(atoi((to_string(a) + to_string(b)).c_str()), 2 * a * b);
}