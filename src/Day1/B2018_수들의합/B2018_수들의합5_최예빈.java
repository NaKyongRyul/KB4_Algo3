package com.itskb.codingtest.basic;

import java.util.Scanner;

public class B2018_수들의합5_최예빈 {

    static long N, count;
    static long low, high, lowSum, highSum, tempSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextLong();

        low = 1;
        high = 1;

        while (high < N + 1) {

            if (high - low > N) {
                low++;
                continue;
            } else if (high - low < 0) {
                high++;
            }

            highSum = high * (high + 1) / 2;

            lowSum = low * (low - 1) / 2;

            if (low == high) tempSum = high;
            else tempSum = highSum - lowSum;

            if (tempSum == N) {
                count++;
                high++;
            } else if (tempSum < N) high++;
            else low++;
        }

        System.out.println(count);
    }
}
