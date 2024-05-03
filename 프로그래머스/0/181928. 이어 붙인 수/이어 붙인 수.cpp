#include <vector>
#include <iostream>
#include <string>

using namespace std;

int solution(vector<int> num_list) {
    string odd, even;
    
    for (int num : num_list) {
        if (num % 2 == 0) even += to_string(num);
        else odd += to_string(num);
    }
    
    return atoi(odd.c_str()) + atoi(even.c_str());
}