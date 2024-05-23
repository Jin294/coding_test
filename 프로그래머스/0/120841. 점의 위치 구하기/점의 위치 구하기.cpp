#include <vector>

using namespace std;

int solution(vector<int> dot) {
    int answer = 0;
    
    if (dot[0] > 0) { // 1, 4
        if (dot[1] > 0) return 1;
        else return 4;
    } else { // 2, 3
        if (dot[1] > 0) return 2;
        else return 3;
    }
}