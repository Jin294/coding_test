#include <vector>

using namespace std;

bool isArraySame(vector<int> &one, vector<int> &two) {
    return one == two;
}

void calcVector(vector<int> &tmp) {
    for (int &value : tmp) {
        if (value % 2 == 0 && value > 50) {
            value /= 2;
        } else if (value % 2 == 1 && value < 50)  {
            value = value * 2 + 1;
        }
    }
}

int solution(vector<int> arr) {
    int count = 0;
    vector<int> tmp = arr;
    
    calcVector(tmp);
    while (!isArraySame(arr, tmp)) {
        count++;
        arr = tmp;
        calcVector(tmp);
    }

    return count;
}

