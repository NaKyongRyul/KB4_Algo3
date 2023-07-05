package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2018_수들의합5_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = N / 2 + 1;
        int ans = 1;

        int i = 1;  // start
        int j = 2;  // end

        while (i < M && j <= M) {
            double n = ((i + j) / 2.0) * (j - i + 1);   // double로 안 하면 못 찾는 경우 생김
            if (n == N) {
                ans++;
                j++;
            }
            else if (n > N) {
                i++;
            } else if (n < N) {
                j++;
            }
        }

        System.out.println(ans);
    }
}
