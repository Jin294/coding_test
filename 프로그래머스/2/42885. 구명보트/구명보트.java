import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        // 가장 가벼운 사람을 가리키는 인덱스
        int min = 0;
        
        // max는 가장 무거운  사람을 가리키는 인덱스
        // max가 min보다 크거나 같을동안 반복
        // 즉, 아직 보트에 탑승하지 않은 사람이 있는동안 반복
        for (int max = people.length - 1; min <= max; max--) {
            // 가장 가벼운 사람과 가장 무거운 사람이 함께 탈 수 있다면
            if (people[min] + people[max] <= limit) {
                min++; // 가장 가벼운 사람은 구조됨 -> 증가시킴
            }
            
            // 가장 무거운 사람 구조했으므로 구병보트 수 증가시킴
            // 무게 제한 때문에 가장 가벼운 사람과 가장 무거운 사람이 함께 탑승하지 못한다면, 가장 무거운 사람만 탑승
            answer++;
        }
        
        return answer;
    }
}