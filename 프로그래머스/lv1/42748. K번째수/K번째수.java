import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int tc = 0; tc < commands.length; tc ++) {
            int start = commands[tc][0];
            int end = commands[tc][1];
            int k = commands[tc][2];

            int[] slice = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(slice);
            answer[tc] = slice[k - 1];
        }
        return answer;
    }
}