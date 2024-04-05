import java.util.*;

class Solution {
    int diff, aSum, rSum;
    int[] gRyan = new int[11];
    public int[] solution(int n, int[] info) {
        makeRyanArray(n, 0, info, new int[11]);
        
        if (diff == 0) {
            return new int[]{-1};
        }
        
        return gRyan;
    }
    
    // n발의 화살을 라이언에게 분배하기
    // 화살이 남아있을 때, 어피치보다 많으면 됨
    public void makeRyanArray(int remain, int idx, int[] apeach, int[] ryan) {
        // 꼭 모든 화살을 다 사용해야 한다.
        // 화살을 다 사용했다면 점수계산
        if (idx == 11) {
            ryan[10] = remain;
            calc(apeach, ryan);
            
            // 라이언 점수가 어피치보다 클 때
            if (aSum < rSum && diff <= rSum - aSum) {
                // 점수 차이가 더 커지게
                if (diff < rSum - aSum) {
                    diff = rSum - aSum;
                    gRyan = ryan.clone();
                } else if (diff == rSum - aSum) {
                    // 점수 차이가 같다면
                    if (getLower(ryan)) {
                        gRyan = ryan.clone();
                    }
                }
            }
            
            ryan[10] = 0;
            return;
        }
        
        // 남아있는 화살이 어피치가 맞힌 화살보다 많거나 같다면
        // 라이언이 맞힐 가치가 있음
        if (remain > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            makeRyanArray(remain - ryan[idx], idx + 1, apeach, ryan);
            ryan[idx] = 0;
        }
        
        // 라이언이 해당 칸을 맞히지 않았을 때
        makeRyanArray(remain, idx + 1, apeach, ryan);
    }
    
    public boolean getLower(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if (gRyan[i] > 0 || ryan[i] > 0) {
                if (gRyan[i] < ryan[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        return false;
    }
    
    
    public void calc(int[] apeach, int[] ryan) {
        aSum = 0;
        rSum = 0;
        for (int i = 0; i < 11; i++) {
            if (ryan[i] > apeach[i] && ryan[i] > 0) {
                rSum += 10 - i;
            } else if (ryan[i] < apeach[i] && apeach[i] > 0) {
                aSum += 10 - i;
            }
        }
    }
}