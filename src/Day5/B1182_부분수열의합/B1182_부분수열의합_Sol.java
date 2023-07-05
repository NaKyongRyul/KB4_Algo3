package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_부분수열의합_Sol {
    static int N, S;
    static int[] arr = new int[20];
    static int ans;

    static void dfs(int idx, int sum) {
        if (sum == S && idx > 0) {
        	System.out.println("++");
            ans++;
        }
        for (int i = idx; i < N; i++) {
        	System.out.println(i +" / "+ sum);
            dfs(i + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0);

        System.out.println(ans);
    }
}
