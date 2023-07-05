package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_임재현 {
    public static void main(String[] args) {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int ans = 1;
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int p1 = 1, p2 = 2;
        int sum = 3;
        int flag = (N + 1) / 2;
        while (p1 < p2 && p2 <= flag) {
            if (sum < N) {
                p2++;
                sum += p2;
            } else if (sum > N) {
                sum -= p1;
                p1++;
            } else {
                ans++;
                sum -= p1;
                p1++;
            }
        }

        System.out.println(ans);
    }

}
