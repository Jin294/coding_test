import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> setList = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                unionSet(setList.get(i), setList.get(i - j), setList.get(j));                
            }
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));
            
            for (int num : setList.get(i)) {
                if (num == number) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1 : a) {
            for (int n2 : b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if (n2 != 0)
                    union.add(n1 / n2);
            }
        }
    }
}