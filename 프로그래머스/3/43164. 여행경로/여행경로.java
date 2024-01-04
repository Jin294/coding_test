import java.util.*;

class Solution {
    static int len;
    static String[][] gTickets;
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        gTickets = tickets;
        len = tickets.length;
        visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            String[] ticket = tickets[i];
            if (ticket[0].equals("ICN")) {
                visited[i] = true;
                DFS(1, i, "ICN");
                visited[i] = false;
            }
        }
        Collections.sort(list);
        String target = list.get(0);
        String[] answer = new String[target.length() / 3];
        int idx = 0;
        for (int i = 0; i < target.length(); i += 3) {
            answer[idx++] = target.substring(i, i + 3);
        }
        return answer;
    }
    
    public void DFS(int depth, int idx, String now) {
        if (depth == len) {
            list.add(now + gTickets[idx][1]);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i] && gTickets[i][0].equals(gTickets[idx][1])) {
                visited[i] = true;
                DFS(depth + 1, i, now + gTickets[idx][1]);
                visited[i] = false;
}
        }
    }
}