package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_김원우 {

    static int n;
    static int k;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int cnt = 0;

        for (int i = n-1; i >= 0; i--) {
            while (sum + coin[i] <= k) {
//                System.out.println("coin: " + coin[i]);
                cnt++;
                sum += coin[i];
            }
        }

//        System.out.println(sum);
        System.out.println(cnt);


    }
}
