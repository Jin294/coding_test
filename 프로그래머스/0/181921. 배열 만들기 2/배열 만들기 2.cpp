#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void recursion(int len, int now, string str, vector<int>* list) {
    if (len == now) {
        (*list).push_back(atoi(str.c_str()));
        return;
    }
    
    recursion(len, now + 1, str + "5", list);
    recursion(len, now + 1, str + "0", list);
}

vector<int> solution(int l, int r) {
    vector<int> list = {0, 5};
    
    for (int i = 2; i <= 7; i++) {
        recursion(i, 1, "5", &list);
    }
    
    sort(list.begin(), list.end());
    
    vector<int> answer;
    for (int i = 0; i < list.size(); i++) {
        if (list[i] >= l && list[i] <= r) {
            answer.push_back(list[i]);
        }
    }
    
    if (answer.size() == 0) {
        answer.push_back(-1);
    }
    return answer;
}