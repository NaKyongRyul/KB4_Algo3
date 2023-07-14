package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_김진형 {
    static int[][] arr;
    static int N;
    static int R;
    static boolean[] isSelected;
    static int[] select;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i) {
            R = i;
            isSelected = new boolean[N];
            select = new int[R];
            combination(0, 0);
        }

        System.out.println(ans);

    }

    private static void combination(int r, int idx) {
        if (r == R) {
            int S = 1;
            int M = 0;
            for (int i = 0; i < R; ++i) {
                S *= arr[select[i]][0];
                M += arr[select[i]][1];
            }
            ans = Math.min(Math.abs(S - M), ans);
            return;
        }
        for (int i = idx; i < N; ++i) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            select[r] = i;
            combination(r + 1, idx + 1);
            isSelected[i] = false;
        }

    }
}
