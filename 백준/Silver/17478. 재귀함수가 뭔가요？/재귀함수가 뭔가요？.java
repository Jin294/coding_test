import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder answer;
    static String[] str1, str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        str1 = new String[4];
        str1[0] = "\"재귀함수가 뭔가요?\"\n";
        str1[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        str1[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        str1[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

        str2 = new String[3];
        str2[0] = "\"재귀함수가 뭔가요?\"\n";
        str2[1] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        str2[2] = "라고 답변하였지.\n";
        recursion(0);
        System.out.println(answer);
    }

    private static void recursion(int depth) {
        if (depth == n) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < depth; j++) {
                    answer.append("____");
                }
                answer.append(str2[i]);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < depth; j++) {
                answer.append("____");
            }
            answer.append(str1[i]);
        }

        recursion(depth + 1);
        for (int i = 0; i < depth; i++) {
            answer.append("____");
        }
        answer.append(str2[2]);
    }
}