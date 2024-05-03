#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> num_list) {
    int one = 1;
    
    for (int num : num_list) {
        one *= num;
    }
    
    int sum = accumulate(num_list.begin(), num_list.end(), 0);
    return one < sum * sum? 1 : 0;
}