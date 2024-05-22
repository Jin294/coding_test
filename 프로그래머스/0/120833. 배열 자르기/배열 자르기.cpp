#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers, int num1, int num2) {
    auto it = numbers.begin();
    return vector<int> (it + num1, it + num2 + 1);
}