package Day1.B2018_수들의합;

import java.util.Scanner;

/**
 * 투 포인터
 */
public class B2018_수들의합_이소형 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + i;
        }

        int start = 1, end = 1, temp, cnt = 0;
        while (start <= end && end <= n) {
            temp = sums[end] - sums[start - 1];
            if (temp == n) cnt++;
            if (temp < n) end++;
            else start++;
        }

        System.out.println(cnt);
    }
}
