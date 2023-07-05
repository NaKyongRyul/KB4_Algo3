package day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2839_설탕배달_신선영 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int s = N / 5;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= s; i++) {
            int n = N;
            int a = i;

            n -= (5 * i);
            if (n % 3 == 0) {
                a += n / 3;
                n = n % 3;
            }

            if (n == 0) {
                ans.add(a);
            }
        }

        if (ans.size() > 0) {
            System.out.println(Collections.min(ans));
        } else System.out.println(-1);
    }
}
