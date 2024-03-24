import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            int code = d[0];
            int date = d[1];
            int maximum = d[2];
            int remain = d[3];
            
            select(ext, list, d, val_ext);
        }
        
        sort(sort_by, list);
        
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void select(String ext, List<int[]> list, int[] now, int val) {
        int basis = map.get(ext);

        if (now[basis] < val) {
            list.add(now);
        }
    }
    
    public void sort(String x, List<int[]> list) {
        int idx = map.get(x);

        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[idx] - o2[idx];
            }
        });
        
    }
}