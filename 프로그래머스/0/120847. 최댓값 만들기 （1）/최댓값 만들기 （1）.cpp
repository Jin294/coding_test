#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> numbers) {
    sort(numbers.begin(), numbers.end());
    size_t len = numbers.size();
    return numbers[len - 1] * numbers[len - 2];
}