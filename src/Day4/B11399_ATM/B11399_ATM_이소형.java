package Day4.B11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399_ATM_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] strings = reader.readLine().split(" ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(p);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += p[i] * (n - i);
        }
        System.out.println(result);
    }
}
