import java.util.*;

class Solution {
    // 1. 1부터 주어진 문자열 s의 길이만큼 자를 문자열의 길이 설정
    // 2. 설정된 길이만큼 문자열을 잘라낸 token의 배열 생성
    // 3. 문자열을 비교하며 토큰의 배열을 하나의 문자열로 압축
    // 4. 압축된 문자열 중 가장 짧은 길이 반환
    public int solution(String s) {
        int min = 1_000;
        for (int i = 1; i <= s.length(); i++) {
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, i);
            // System.out.println(compressed);
            if (compressed < min) {
                min = compressed;
            }
        }
        
        return min;
    }
    
    public int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();
        
        // 연속으로 중복된 문자열을 검사해야 한다
        String last = ""; // 직전 문자열
        int count = 0; // 직전 문자열의 등장 횟수
        for (String token : split(source, length)) {
            // 압축 문자열 구성
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);
       
        return sb.length();
    }
    
    public List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        
        // source를 length만큼 잘라 tokens에 넣는다
        for (int start = 0; start < source.length(); start += length) {
            int end = start + length;
            if (end > source.length()) {
                end = source.length();
            }
            tokens.add(source.substring(start, end));
        }
       
        return tokens;
    }
}