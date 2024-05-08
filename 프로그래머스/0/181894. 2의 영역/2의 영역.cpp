#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    
    // 앞부분
    auto start = find(arr.begin(), arr.end(), 2);
    
    // start가 마지막 위칫값과 같다는 것은, 해당 데이터가 없다는것!
    if (start == arr.end()) {
        return {-1};
    }
    
    // 뒷부분 : 역방향 반복자!!
    auto end = find(arr.rbegin(), arr.rend(), 2);
    
    // 범위 내의 요소 추려내기
    // 왜 base()를 쓰냐?
    // => end가 역방향 반복자라, 순방향 반복자로 바꿔주기위해!
    vector<int> answer(start, end.base());
    
    return answer;
}