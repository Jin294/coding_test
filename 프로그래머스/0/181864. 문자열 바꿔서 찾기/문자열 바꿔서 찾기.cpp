#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    // A to B, B to A
    for (char& ch : myString) {
        if (ch == 'A') ch = 'B';
        else ch = 'A';
    }
    
    auto answer = myString.find(pat);
    
    return answer != string::npos ? 1 : 0;
}