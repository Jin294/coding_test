#include <string>
#include <algorithm>

using namespace std;

int solution(int a, int b) {
    string one = to_string(a) + to_string(b);
    string two = to_string(b) + to_string(a);

    return max(stoi(one), stoi(two));
}