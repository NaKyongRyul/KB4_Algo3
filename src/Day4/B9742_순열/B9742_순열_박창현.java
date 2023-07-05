package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_박창현 {
    static char[] rawArr;
    static int count;
    static int[] selArr;
    static boolean[] isIn;
    static String[] s;

    static void permutation(int r, StringBuilder sb) {
        if (r == rawArr.length) {
            if (count == Integer.parseInt(s[1])) {
                for (int i = 0; i < r; i++) {
                    sb.append(rawArr[selArr[i]]);
                }
            }
            count++;
            return;
        }
        for (int i = 0; i < rawArr.length; i++) {
            if (isIn[i]) continue;
            isIn[i] = true;
            selArr[r] = i;
            permutation(r + 1, sb);
            isIn[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String input;
        do {
            input = br.readLine();
            s = input.split(" ");
            rawArr = s[0].toCharArray();
            selArr = new int[rawArr.length];
            isIn = new boolean[rawArr.length];
            count = 1;
            StringBuilder sb = new StringBuilder();
            permutation(0, sb);
            result.append(input).append(" = ").append(sb.length() > 0 ? sb : "No permutation").append("\n");
        } while (br.ready());
        br.close();
        System.out.println(result);
    }
}
