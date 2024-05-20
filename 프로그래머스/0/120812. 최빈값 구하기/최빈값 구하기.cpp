#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> array) {
    vector<int> count(1000);
    fill(count.begin(), count.end(), 0);
    sort(array.begin(), array.end());
    for (int num : array) count[num]++;
    
    // 최빈값 == 최고로 많이 나온 키
    int key = -1;
    
    // 최빈값의 개수
    int val = *max_element(count.begin(), count.end());
    
    // 최빈값이 둘 이상인지 확인
    int cnt = 0;
    for (int i = 0; i < 1000; i++) {
        if (count[i] == val) {
            key = i;
            cnt++;
        }
    }
    
    // 최빈값이 여러개라면 -1을 리턴
    if (cnt > 1) return -1;
    return key;
}