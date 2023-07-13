package com.itskb.codingtest.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_최예빈 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        quickSort(0, N - 1);

        for (int i = 0; i < N; i++) System.out.println(arr[i]);
    }

    private static void quickSort(int left, int right) {
        int pivot = left; // 맨 왼쪽
        int pl = left;
        int pr = right;

        do {
            while (arr[pl] < arr[pivot]) pl++;
            while (arr[pr] > arr[pivot]) pr--;
            if (pl <= pr) swap(pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(left, pr);
        if (pl < right) quickSort(pl, right);
    }

    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
