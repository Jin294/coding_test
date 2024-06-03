#include <string>

using namespace std;

int solution(string A, string B) {
    if (A == B) return 0;
    
    for (int i = 1; i < A.size(); i++) {
        string cmp = A.substr(A.size() - i, i) + A.substr(0, A.size() - i);
        
        if (cmp == B) return i;
    }
    
    return -1;
}