package Day1.B11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11660_구간합구하기5_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        int[][] sums = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            strings = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                sums[i][j + 1] += sums[i - 1][j + 1] + sums[i][j] + Integer.parseInt(strings[j]) - sums[i - 1][j];
            }
//            System.out.println(Arrays.toString(sums[i]));
        }

        int x1, y1, x2, y2, result;
        for (int i = 0; i < m; i++) {
            strings = reader.readLine().split(" ");
            x1 = Integer.parseInt(strings[0]);
            y1 = Integer.parseInt(strings[1]);
            x2 = Integer.parseInt(strings[2]);
            y2 = Integer.parseInt(strings[3]);

            result = sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
