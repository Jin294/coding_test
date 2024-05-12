#include <string>

using namespace std;

string solution(string myString, string pat) {
    return myString.substr(0, pat.size() + myString.rfind(pat));
}