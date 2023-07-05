package Day4.B15650_N과M1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B15650_N과M1_김원우 {
    static int [] arr;
    static boolean [] visited;
    static int n;
    static int m;
    static int [] temp;
    static void combination(int r, int start) {
        if (r == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(temp[i]+1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[r] = i;
            combination(r + 1, i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        visited = new boolean[n];
        temp = new int[m];

        combination(0, 0);

    }
}
