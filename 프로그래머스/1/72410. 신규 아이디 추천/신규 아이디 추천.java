class Solution {
    public String solution(String new_id) {
        // 1단계 : 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2단계 : 특수문자 제거
        new_id = new_id.replaceAll("[^a-zA-Z0-9\\-\\_\\.]", "");
        
        // 3단계 : 마침표가 2번 이상이면 하나로 치환
        new_id = new_id.replaceAll("\\.+", ".");
        
        // 4단계 : 마침표가 처음이나 끝이라면 제거
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 5단계 : 빈 문자열은 a로
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        
        // 6단계 : 15개까지만
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 7단계 : 길이 2 미만은 불리기
        if (new_id.length() <= 2) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}