package Day5.B15650_N과M1;

import java.util.Scanner;

public class B15650_N과M1_이소형 {

    static int n;
    static int m;
    static int[] selected;
    static boolean[] isSelected;

    static void combination(int r, int idx) {

        if (r == m) {
            for (int e :
                    selected) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (isSelected[i]) continue;

            selected[r] = i;
            isSelected[i] = true;
            combination(r + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        selected = new int[m];
        isSelected = new boolean[n + 1];

        combination(0, 1);
    }
}
