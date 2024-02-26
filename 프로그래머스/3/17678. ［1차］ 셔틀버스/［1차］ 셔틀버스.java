import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] curr = s1.split(":");
                String[] next = s2.split(":");
                
                int curH = Integer.parseInt(curr[0]);
                int curM = Integer.parseInt(curr[1]);
                
                int nxtH = Integer.parseInt(next[0]);
                int nxtM = Integer.parseInt(next[1]);
                
                return (curH * 60 + curM) - (nxtH * 60 + nxtM);
            }
        });
        
        int startTime = 9 * 60;
        int lastTime = 0;
        
        int seat = 0; // 현재 버스의 자리
        int idx = 0; // 크루 순서
        
        for (int i = 0; i < n; i++) {
            seat = 0;
            while (idx < timetable.length) {
                int crewTime = getConvertedTime(timetable[idx]);
                // 크루의 도착시간이 버스 도착시간 전이라면 또는 딱 맞게 왔다면
                // 동시에 현재 회차의 버스 자리가 남아있다면
                if (startTime >= crewTime && seat < m) {
                    idx++;
                    seat++;
                } else { // 시간이 맞지 않거나, 버스자리가 없다면
                    break;
                }
                
                lastTime = crewTime - 1;
            }
            
            // 도착시간(출발시간)을 다음회차 시간으로 조정
            startTime += t;
        }
        
        // 만석이 아니라면 => 이전 버스시간의 도착시간에 타면 된다.
        if (seat < m) {
            lastTime = startTime - t;
        }
        
        return getOriginalTime(lastTime);
    }
    
    public int getConvertedTime(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    public String getOriginalTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}