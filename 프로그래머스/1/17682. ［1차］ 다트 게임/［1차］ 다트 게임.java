import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] nums = getNums(dartResult);
        List<String> others = deleteNums(dartResult);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            String str = others.get(i);
            nums[i] = calcBonus(str.charAt(0), nums[i]);
                        
            if (str.length() > 1) {
                calcAwarded(nums, i, str.charAt(1));               
            }
        }
        
        return Arrays.stream(nums).sum();
    }
    
    // 상받은거 계산
    public void calcAwarded(int[] nums, int i, char option) {
        if (option == '*') {
            // 스타상 당첨 시 해당점수를 2배
            nums[i] *= 2;

            // 바로 전에 얻은 점수도 2배
            if (i != 0) {
                nums[i - 1] *= 2;
            }
        } else if (option == '#') {
            // 아차상 당첨시 해당 점수는 마이너스
            nums[i] *= -1;
        }
    }
    
    // 문자열에서 점수만 구하기
    public int[] getNums(String s) {
        List<Integer> numList = new ArrayList<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(arr[i])) {
                sb.append(arr[i]);
            } else {
                if (sb.length() > 0) {
                    numList.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        
        int[] nums = new int[numList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }
        
        return nums;
    }
    
    // 문자열에서 점수만 빼기
    public List<String> deleteNums(String s) {
        String[] ss = s.split("[0-9]");
        List<String> result = new ArrayList<>();
        for (String x : ss) {
            if (x.length() > 0) {
                result.add(x);
            }
        }
        return result;
    }
    
    // 보너스 계산
    public int calcBonus(char x, int score) {
        switch(x) {
            case 'S':
                return score;
            case 'D':
                return (int) Math.pow(score, 2);
            case 'T':
                return (int) Math.pow(score, 3);
        }
        
        return 0;
    }
}