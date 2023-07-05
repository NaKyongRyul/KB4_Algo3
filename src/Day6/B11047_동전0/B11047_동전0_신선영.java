package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11047_동전0_신선영 {
    static Integer[] money;
    static int N;
    static int K;

    static int calculate(int k) {
        int ans = 0;
        for (int m : money) {
            if (k >= m) {
                ans += k / m;
                k = k % m;
            }

            if (k == 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 동전의 종류
        K = Integer.parseInt(st.nextToken());   // 만들어야 하는 가치의 합

        money = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }

        // 최솟값을 위해서는 큰 값부터 확인하는 것이 좋음 - 내림차순 정렬
        Arrays.sort(money, Collections.reverseOrder());

        System.out.println(calculate(K));

    }
}
