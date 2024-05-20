#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> array) {
    vector<int> count(1000, 0); // 생성 및 0으로 초기화
    for (int num : array) count[num]++;
    
    // 최빈값 == 최고로 많이 나온 키
    int key = -1;
    
    // 최빈값의 개수
    // max_element는 iterator를 반환하기 때문에 *를 붙여야 값을 가져올 수 있음
    int val = *max_element(count.begin(), count.end());
    
    // 최빈값이 둘 이상인지 확인
    int cnt = 0;
    for (int i = 0; i < 1000; i++) {
        if (count[i] == val) {
            key = i;
            cnt++;
            
            // 최빈값이 여러개라면 -1을 리턴
            if (cnt > 1) return -1;
        }
    }
    
    return key;
}