package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_김진형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;

        for (int i = N - 1; i >= 0; --i) {
            int coinCnt = 0;
            coinCnt += K / array[i];
            K -= array[i] * coinCnt;
            ans += coinCnt;
        }
        System.out.println(ans);
    }
}