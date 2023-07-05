package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_박창현 {
    static int[] arr;
    static int N;
    static int R;
    static int[] sel;
    static boolean[] isSel;

    static void combination(int r, int s) {
        if (r == R) {
            for (int i = 0; i < R; i++) {
                System.out.print(arr[sel[i]]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i < arr.length; i++) {
            if (isSel[i]) continue;
            isSel[i] = true;
            sel[r] = i;
            combination(r + 1, i);
            isSel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sel = new int[R];
        isSel = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        combination(0, 0);
    }
}
