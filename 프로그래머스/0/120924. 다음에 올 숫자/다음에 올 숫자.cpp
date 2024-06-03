#include <vector>

using namespace std;

int solution(vector<int> common) {
    int last = common[common.size() - 1];
    if (common[1] - common[0] == common[2] - common[1]) {
        // 등차
        return last + common[1] - common[0];
    } else {
        // 등비
        return last * (common[1] / common[0]);
    }
}