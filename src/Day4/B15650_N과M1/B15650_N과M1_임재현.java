package Day4.B15650_N과M1;

import java.util.Scanner;

public class B15650_N과M1_임재현 {
    static int[] selected = new int[8];
    static int N, M;

    static void combination(int cnt, int idx) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) {
            selected[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());

        combination(0, 1);
        sc.close();
    }
}
