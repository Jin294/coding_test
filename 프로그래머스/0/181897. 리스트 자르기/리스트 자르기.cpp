#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int n, vector<int> slicer, vector<int> num_list) {
    vector<int> answer;
    int a = slicer[0];
    int b = slicer[1];
    int c = slicer[2];
    
    switch(n) {
        case 1:
            num_list.erase(num_list.begin() + b + 1, num_list.end());
            break;
        case 2:
            num_list.erase(num_list.begin(), num_list.begin() + a);
            break;
        case 3:
            num_list.erase(num_list.begin() + b + 1, num_list.end());

            num_list.erase(num_list.begin(), num_list.begin() + a);
            break;
        case 4:
            num_list.erase(num_list.begin() + b + 1, num_list.end());

            num_list.erase(num_list.begin(), num_list.begin() + a);
            
            for (int i = 0; i < num_list.size(); i += c) {
                answer.push_back(num_list[i]);
            }
            return answer;
    }
    
    return num_list;
}