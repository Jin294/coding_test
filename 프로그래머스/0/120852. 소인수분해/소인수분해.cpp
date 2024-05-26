#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int n) {
    vector<int> prime(n + 1, 0);
    
    prime[0] = prime[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        for (int j = i * i; j <= n; j += i) {
            prime[j]++;
        }
    }
    
    vector<int> answer;
    for (int i = 2; i <= n; i++) {
        if (prime[i] == 0 && n % i == 0) answer.push_back(i);
    }
    
    return answer;
}