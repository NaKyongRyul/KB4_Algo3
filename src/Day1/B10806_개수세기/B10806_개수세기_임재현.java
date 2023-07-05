package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_임재현 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int ans = 0;
        StringTokenizer token = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int v = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            if (arr[i] == v) ans++;
        }

        System.out.println(ans);
    }
}