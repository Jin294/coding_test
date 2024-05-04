#include <string>

using namespace std;

void calc(int* n, char x) {
    switch(x) {
        case 'w':
            (*n)++;
            break;
        case 's':
            (*n)--;
            break;
        case 'd':
            (*n) += 10;
            break;
        case 'a':
            (*n) -= 10;
            break;
    }
}

int solution(int n, string control) {
    for (char x : control) {
        calc(&n, x);
    }
    
    return n;
}