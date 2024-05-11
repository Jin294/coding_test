#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    for (auto& num : arr) {
        if (num >= 50 && ((num & 1) == 0)) num /= 2;
        else if (num < 50 && ((num & 1) == 1)) num *= 2;
    }
    
    return arr;
}