#include <vector>

using namespace std;

int solution(vector<int> array, int n) {    
    // 카운트 정렬
    vector<int> cnt (1001, 0);
    
    for (int num : array) cnt[num]++;
        
    return cnt[n];
}