#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> array, int n) {
    // 오름차순 정렬
    sort(array.begin(), array.end());
    
    int diff = n;
    int answer = array[0];
    for (int num : array) {
        // 현재 원소와의 차이가, 저장된 차잇값보다 크다
        // 오름차순 정렬했으므로, 앞으로 큰값만 계속 나온다.
        if (abs(n - num) > diff) {
            return answer;
        }
        
        // 현재 원소와의 차이가, 저장된 차잇값보다 크다
        // 가장 가까운수가 여러개일 경우, 더 작은 수를 저장한다.
        if (abs(n - num) == diff) {
            answer = min(answer, num);
        } else {
            // 현재 원소와의 차이가, 저장된 차잇값보다 작다
            // 지금 수 저장
            answer = num;
            diff = abs(n - num);
        }
    }
    
    return answer;
}