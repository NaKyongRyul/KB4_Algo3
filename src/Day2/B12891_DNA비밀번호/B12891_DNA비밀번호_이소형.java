package Day2.B12891_DNA비밀번호;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B12891_DNA비밀번호_이소형 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();  // DNA 문자열 길이
        int p = scanner.nextInt();  // 부분문자열의 길이

        scanner.nextLine();
        String string = scanner.nextLine(); // DNA 문자열

        Map<Character, Integer> dna = new HashMap<>();
        dna.put('A', 0);
        dna.put('C', 1);
        dna.put('G', 2);
        dna.put('T', 3);
        int[] cnt = new int[4];
        for (int i = 0; i < 4; i++) {
            cnt[i] = scanner.nextInt();
        }

        char c;
        for (int i = 0; i < p; i++) {
            c = string.charAt(i);
            cnt[dna.get(c)]--;
        }
        int answer = 0, temp;
        int start = 0, end = p - 1;
        while (true) {
            temp = 0;
            for (int i = 0; i < 4; i++) {
                if (cnt[i] <= 0) temp++;
            }
            if (temp == 4) answer++;

            if (end == s - 1) break;

            c = string.charAt(start++);
            cnt[dna.get(c)]++;
            c = string.charAt(++end);
            cnt[dna.get(c)]--;
        }

        System.out.println(answer);
    }
}
