import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Egg {
    int durability;
    int weight;

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }
}
public class Main {
    static int n, answer;
    static Egg[] eggs;
    static boolean[] cracked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(a, b);
        }

        cracked = new boolean[n];
        crackEggs(0, 0);
        System.out.println(answer);
    }

    public static void crackEggs(int now, int crackedEgg) {
        // now가 없을 때 == 마지막 계란이 now - 1(제일 오른쪽) 일 때
        if (now == n) {
            answer = Math.max(answer, crackedEgg);
            return;
        }

        // 다음 두 가지 조건 중 하나를 만족하면 넘어간다
        // 1. 손에 든 계란(now)이 깨졌다면 넘어간다
        // 2. 모든 계란이 깨져있다면
        if (cracked[now] || crackedEgg == n - 1) {
            crackEggs(now + 1, crackedEgg);
        } else {
            // now 계란으로 i번째 계란을 친다.
            for (int i = 0; i < n; i++) {
                if (now == i) {
                    continue;
                }

                if (!cracked[i]) { // 내려칠 계란이 깨지지 않았다면
                    crackedEgg = hitEgg(now, i, crackedEgg);
                    crackedEgg = hitEgg(i, now, crackedEgg);

                    // 손에 든 now의 다음계란
                    crackEggs(now + 1, crackedEgg);

                    crackedEgg = recoverEgg(now, i, crackedEgg);
                    crackedEgg = recoverEgg(i, now, crackedEgg);
                }
            }
        }
    }

    // 계란 깨기
    public static int hitEgg(int handEgg, int targetEgg, int crackedEgg) {
        eggs[handEgg].durability -= eggs[targetEgg].weight;

        if (eggs[handEgg].durability <= 0) {
            crackedEgg++;
            cracked[handEgg] = true;
        }
        
        return crackedEgg;
    }

    // 깬 계란 원상복구
    public static int recoverEgg(int handEgg, int targetEgg, int crackedEgg) {
        eggs[handEgg].durability += eggs[targetEgg].weight;

        if (cracked[handEgg]) {
            crackedEgg--;
            cracked[handEgg] = false;
        }

        return crackedEgg;
    }
}