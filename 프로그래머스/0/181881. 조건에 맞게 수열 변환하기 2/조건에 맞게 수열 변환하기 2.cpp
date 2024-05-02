#include <string>
#include <vector>

using namespace std;

bool isArraySame(vector<int> &one, vector<int> &two) {
    for (int i = 0; i < one.size(); i++) {
        if (one[i] != two[i]) {
            return false;
        }
    }
    return true;
}

void calcVector(vector<int> &tmp) {
    for (int i = 0; i < tmp.size(); i++) {
        if (tmp[i] % 2 == 0 && tmp[i] > 50) {
            tmp[i] /= 2;
        } else if (tmp[i] % 2 == 1 && tmp[i] < 50)  {
            tmp[i] = tmp[i] * 2 + 1;
        }
    }
}

int solution(vector<int> arr) {
    int count = 0;
    vector<int> tmp = arr;
    
    calcVector(tmp);
    while (!isArraySame(arr, tmp)) {
        count++;
        copy(tmp.begin(), tmp.end(), arr.begin());
        calcVector(tmp);
    }

    return count;
}

