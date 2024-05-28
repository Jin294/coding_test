#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> s1, vector<string> s2) {
    map<string, int> mapp;
    for (string s : s1) mapp[s]++;
    
    int answer = 0;
    for (string s : s2) if (mapp[s] > 0) answer++;
    
    return answer;
}