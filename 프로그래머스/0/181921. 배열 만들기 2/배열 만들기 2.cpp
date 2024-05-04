#include <vector>
#include <algorithm>

using namespace std;

void generateNumber(int start, int end, int num, vector<int>& answer) {
    if (num >= start && num <= end) {
        answer.push_back(num);
    }
    
    if (num > end) return;
    
    generateNumber(start, end, num * 10, answer);
    generateNumber(start, end, num * 10 + 5, answer);
}

vector<int> solution(int l, int r) {
    vector<int> answer;
    
    if (l == 0) answer.push_back(l);
    
    generateNumber(l, r, 5, answer);
        
    sort(answer.begin(), answer.end());
    
    if (answer.empty()) {
        answer.push_back(-1);
    }
    
    return answer;
}