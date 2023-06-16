import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] arr;
    static boolean[] alphabets;
    static String s = "";
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        s = br.readLine();
        while (!(s.equals("end"))) {
            alphabets = new boolean[26];
            arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                alphabets[arr[i] - 'a'] = true;
            }

            // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            if (!alphabets[0]
                    && !alphabets['e' - 'a'] && !alphabets['i' - 'a']
                    && !alphabets['o' - 'a'] && !alphabets['u' - 'a']) {
                isNotAcceptable(s);
                continue;
            }

            // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            int vowel = 0;
            int consonant = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    consonant = 0;
                    vowel++;
                } else {
                    vowel = 0;
                    consonant++;
                }

                if (vowel == 3 || consonant == 3) {
                    break;
                }
            }

            if (vowel == 3 || consonant == 3) {
                isNotAcceptable(s);
                continue;
            }

            // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
            boolean isContinuous = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] != 'e' && arr[i] != 'o') && arr[i] == arr[i + 1]) {
                    isContinuous = true;
                    break;
                }
            }

            if (isContinuous) {
                isNotAcceptable(s);
                continue;
            }


            answer.append("<").append(s).append("> is acceptable.\n");
            s = br.readLine();
        }
        System.out.println(answer);
    }

    static void isNotAcceptable(String word) throws IOException {
        answer.append("<").append(word).append("> is not acceptable.\n");
        s = br.readLine();
    }
}