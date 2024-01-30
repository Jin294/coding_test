import java.util.*;

class Solution {
    static int[] gFees;
    public int[] solution(int[] fees, String[] records) {
        // 요금표를 전역변수에 할당
        gFees = fees;
        
        // 입차 기록을 담을 times
        Map<Integer, Integer> times = new HashMap<>();
        
        // 요금 기록을 담을 result
        Map<Integer, Integer> result = new HashMap<>();
        
        // 차량 번호를 저장하며 작은 순으로 정렬하는 carNums
        PriorityQueue<Integer> carNums = new PriorityQueue<>();
        
        for (String record : records) {
            String[] car = record.split(" ");
            
            String[] time = car[0].split(":");
            int convertedTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            int carNum = Integer.parseInt(car[1]);
            
            String status = car[2];
            
            if (status.equals("IN")) {
                // 차량 입차
                // 입차한 차량번호 기록
                if (!carNums.contains(carNum)) {
                    carNums.add(carNum);
                }
                // 시간 계산 후 times에 넣는다.
                times.put(carNum, convertedTime);
            } else {
                // 차량 출차
                int calculatedTime = convertedTime - times.remove(carNum);
                
                if (result.containsKey(carNum)) {
                    // 이미 시간기록이 된 차량이라면 합산
                    result.put(carNum, result.get(carNum) + calculatedTime);
                } else {
                    // 시간 기록이 없다면
                    result.put(carNum, calculatedTime);
                }
            }
        }
        
        // 출차기록이 없는 차량들을 처리하자.
        // 출차하면서 기록을 지웠기 때문에 남은 차들만 처리하면 된다.
        for (int carNum : times.keySet()) {
            int lastTime = 23 * 60 + 59 - times.get(carNum);
            if (result.containsKey(carNum)) {
                // 이미 내야 할 요금이 있는 차량이라면 요금 계산
                result.put(carNum, result.get(carNum) + lastTime);
            } else {
                // 내야 할 요금이 없는 차량이라면 요금 기록
                result.put(carNum, lastTime);
            }
        }
        
        // 정렬된 차랑 번호의 우선순위 큐에서 번호를 하나씩 뽑아가며
        // result에서 요금 확인 후 배열에 넣는다.
        int[] answer = new int[carNums.size()];
        int idx = 0;
        while(!carNums.isEmpty()) {
            int target = carNums.poll();
            answer[idx++] = calculateFee(result.get(target));
        }
        
        return answer;
    }
    
    public int calculateFee(int min) {
        int calc = min - gFees[0];
        if (calc < 0) {
            return gFees[1];
        } else {
            if (calc % gFees[2] == 0) {
                return gFees[1] + (calc / gFees[2]) * gFees[3];    
            } else {
                return gFees[1] + (calc / gFees[2] + 1) * gFees[3];
            }
        }
    }
}