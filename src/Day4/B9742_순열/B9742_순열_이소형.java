package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_이소형 {

    static int R;
    static char[] arr = new char[10];
    static int N;
    static char[] selected = new char[10];
    static boolean[] isSelected = new boolean[10];

    static void permutation(int r) {

        if (r == R) {
            N--;
            return;
        }

        for (int i = 0; i < R; i++) {
            if (isSelected[i]) continue;

            selected[r] = arr[i];
            isSelected[i] = true;
            permutation(r + 1);
            isSelected[i] = false;
            if (N == 0) return;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] strings;
        StringBuilder builder = new StringBuilder();
        while (s != null && s.length() > 0) {
            builder.append(s);
            strings = s.split(" ");

            R = strings[0].length();
            for (int i = 0; i < R; i++) {
                arr[i] = strings[0].charAt(i);
            }

            N = Integer.parseInt(strings[1]);

            permutation(0);
            builder.append(" = ");
            if (N == 0) {
                for (int i = 0; i < R; i++) {
                    builder.append(selected[i]);
                }
                builder.append("\n");
            }
            else builder.append("No permutation\n");

            s = reader.readLine();
        }

        System.out.println(builder);
    }
}
