#include <iostream>
#include <string.h>
using namespace std;
int main(){
    string str;
    cin >> str;
    char cstr[str.length()];
    strcpy(cstr, str.c_str());
    for (int i = 0; i < str.length(); i++) {
        if(isupper(cstr[i])) cstr[i] = tolower(cstr[i]);
        else cstr[i] = toupper(cstr[i]);
    }
    cout << cstr;
    return 0;
}