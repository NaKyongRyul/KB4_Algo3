package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_신선영 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        for (int a : arr) {
            if (a == v) ans++;
        }

        System.out.println(ans);
    }
}
