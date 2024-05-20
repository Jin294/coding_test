#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    sort(array.begin(), array.end());
    return array[array.size() / 2];
}