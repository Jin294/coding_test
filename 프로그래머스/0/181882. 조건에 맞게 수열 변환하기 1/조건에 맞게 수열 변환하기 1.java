import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays
                .stream(arr)
                .map((x) -> (x >= 50 && ((x & 1) == 0)) ? (x / 2): ((x < 50 && ((x & 1) == 1)) ? (x * 2) : x)).toArray();
    }
}