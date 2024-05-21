#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int odd = 0;
    int even = 0;
    
    for (int num : num_list) {
        if (num & 1 == 1) odd++;
        else even++;
    }
    
    return {even, odd};
}