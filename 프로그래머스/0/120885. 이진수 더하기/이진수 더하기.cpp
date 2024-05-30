#include <bits/stdc++.h>

using namespace std;

int binaryToDecimal(string str) {
    if (str == "0") return 0;
    
    int sum = 0;
    reverse(str.begin(), str.end());
    int now = 1;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '1') sum += now;
        now *= 2;
    }
    
    return sum;
}

string decimalToBinary(int num) {
    if (num == 0) return "0";
    
    string result = "";
    
    while (num > 0) {
        if (num % 2 == 0) result += "0";
        else result += "1";
        
        num /= 2;
    }
    
    reverse(result.begin(), result.end());
    
    return result;
}

string solution(string bin1, string bin2) {
    return decimalToBinary(binaryToDecimal(bin1) + binaryToDecimal(bin2));
}