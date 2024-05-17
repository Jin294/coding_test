#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    if (k & 1 == 1) for (int& num : arr) num *= k;
    else for (int& num : arr) num += k;
    
    return arr;
}