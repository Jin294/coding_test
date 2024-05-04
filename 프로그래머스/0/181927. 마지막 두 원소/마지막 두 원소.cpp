#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int len = num_list.size();
    int back = num_list[len - 1];
    int back_before = num_list[len - 2];
        
    if (back - back_before > 0) {
        num_list.push_back(back - back_before);
    } else {
        num_list.push_back(back * 2);
    }
    
    return num_list;
}