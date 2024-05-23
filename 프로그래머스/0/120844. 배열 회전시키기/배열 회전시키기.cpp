#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> numbers, string direction) {
    if (direction == "left") {
        vector<int> answer (numbers.begin() + 1, numbers.end());
        answer.push_back(numbers[0]);
        return answer;
    }  else {
        vector<int> answer (numbers.begin(), numbers.end() - 1);
        answer.insert(answer.begin(), numbers[numbers.size() - 1]);
        return answer;
    }
}