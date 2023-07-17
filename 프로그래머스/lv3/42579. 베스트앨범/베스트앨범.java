import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class G2P implements Comparable<G2P>{
    String genre;
    int playCount;
    
    public G2P(String genre, int playCount) {
        this.genre = genre;
        this.playCount = playCount;
    }
    
    @Override
    public int compareTo(G2P o) {
        return o.playCount - this.playCount;
    }
}

class Play implements Comparable<Play>{
    int playCount;
    int idx;

    public Play(int playCount, int idx) {
        this.playCount = playCount;
        this.idx = idx;
    }

    @Override
    public int compareTo(Play o) {
        return o.playCount - this.playCount;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, ArrayList<Play>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);

            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Play(plays[i], i));
        }

        ArrayList<G2P> g2p = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            g2p.add(new G2P(entry.getKey(), entry.getValue()));
        }
                    
        Collections.sort(g2p);
                    
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < g2p.size(); i++) {
            ArrayList<Play> tmp = map.get(g2p.get(i).genre);
            Collections.sort(tmp);
            if (tmp.size() == 1) {
                list.add(tmp.get(0).idx);
            } else {
                for (int j = 0; j < 2; j++) {
                    list.add(tmp.get(j).idx);
                }
            }
        }

        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        
        return answer;
    }
}