package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_신동렬 {

    static int cnt;
    static int [] arr;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());

        }

        for (int i=N-1; i>=0; i--){
            if(arr[i]<=K){
                cnt+=K/arr[i];
                K=K%arr[i];
            }
        }
        System.out.println(cnt);
    }
}
