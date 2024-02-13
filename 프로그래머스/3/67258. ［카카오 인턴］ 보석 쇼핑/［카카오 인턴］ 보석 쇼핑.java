import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int len = gems.length;
        int lt = 0;
        int rt = 0;

        // 보석의 인덱스 매기기
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String gem : gems) {
            if (!map.containsKey(gem)) {
                map.put(gem, idx++);
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        int[] countGem = new int[map.size()];

        while (lt < len && rt < len) {
            while (!isAll(countGem) && rt < len) {
                countGem[map.get(gems[rt++])]++;
            }

            while (isAll(countGem) && lt < rt) {
                countGem[map.get(gems[lt++])]--;
            }

            list.add(new int[]{lt, rt});
        }

        for(int[] arr : list) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((o1[1] - o1[0]) == (o2[1] - o2[0])) {
                    return o1[0] - o2[0];
                }
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });

        return list.get(0);
    }

    public boolean isAll(int[] countGem) {
        for (int i = 0; i < countGem.length; i++) {
            if (countGem[i] == 0) {
                return false;
            }
        }

        return true;
    }
}