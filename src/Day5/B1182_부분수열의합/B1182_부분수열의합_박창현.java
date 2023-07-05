package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_부분수열의합_박창현 {
    static int[] arr;
    static boolean[] isSel;
    static int result = 0;
    static int N = 0;
    static int S = 0;

    static void subset(int num) {
        if (num == N) {
            int sum = 0;
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                if (isSel[i]) {
                    flag = true; //공집합 걸러내기
                    sum += arr[i];
                }
            }

            if (S == sum && flag) result++;
            return;
        }

        isSel[num] = false;
        subset(num + 1);

        isSel[num] = true;
        subset(num + 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isSel = new boolean[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        subset(0);
        System.out.println(result);
    }
}
