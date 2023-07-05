package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_박창현 {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(K/arr[i]);
//            System.out.println(K%arr[i]);
//        }
        int point = N-1;
        int calc = K;
        int count = 0;
        while (calc!=0){
            if (calc/arr[point]==0){
                point--;
                continue;
            }
            count += calc/arr[point];
            calc %= arr[point];
        }
        System.out.println(count);
    }
}
