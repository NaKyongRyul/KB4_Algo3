package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_임재현 {
    static int N;
    static int[] S = new int[10];
    static int[] B = new int[10];
    static boolean[] selected = new boolean[10];
    static int min = 1000000001;

    static void checkMin() {
        int sour = 1;
        int bitter = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                sour *= S[i];
                bitter += B[i];
            }
        }
        int res = sour - bitter;
        if (res < 0)
            res *= -1;
        if (res < min)
            min = res;
    }

    static void combination(int index) {
        for (int i = index; i < N; i++) {
            selected[i] = true;
            checkMin();
            combination(i + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(token.nextToken());
            B[i] = Integer.parseInt(token.nextToken());
        }
        combination(0);

        System.out.println(min);
    }
}
