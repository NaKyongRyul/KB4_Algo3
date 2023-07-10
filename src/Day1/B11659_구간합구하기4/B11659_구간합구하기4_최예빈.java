package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 누적합을 구하고 누적합[j-1] - 누적합[i-2]로 구간합을 구한다
 *
 * arr : 원본 배열
 * prefixSum : 누적합 배열
 */
public class B11659_구간합구하기4_최예빈 {

    static BufferedReader br;
    static StringTokenizer st;
    private static int n, m, a, b, answer;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = arr.clone();

        for (int i = 1; i < n; i++) { // O(n)
            prefixSum[i] += prefixSum[i - 1];
        }

        for (int i = 0; i < m; i++) { // O(m)
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 구간합 출력
            if (a - 2 < 0) System.out.println(prefixSum[b - 1]);
            else System.out.println(prefixSum[b - 1] - prefixSum[a - 2]);
        }
    }

}
