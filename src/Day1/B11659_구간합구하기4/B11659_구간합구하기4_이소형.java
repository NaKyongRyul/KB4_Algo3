package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        strings = reader.readLine().split(" ");
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] += sums[i - 1] + Integer.parseInt(strings[i - 1]);;
        }

        int i, j;
        for (int k = 0; k < m; k++) {
            strings = reader.readLine().split(" ");
            i = Integer.parseInt(strings[0]);
            j = Integer.parseInt(strings[1]);
            System.out.println(sums[j] - sums[i - 1]);
        }
    }
}
