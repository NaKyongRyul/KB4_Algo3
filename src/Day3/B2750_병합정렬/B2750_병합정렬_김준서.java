package Day3.B2750_병합정렬;

import java.util.Scanner;

public class B2750_병합정렬_김준서 {
    static int[] buff;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        buff = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, l;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                buff[k++] = arr[i++];
            } else {
                buff[k++] = arr[j++];
            }
        }
        if (i > mid) {
            for (l = j; l <= right; l++) {
                buff[k++] = arr[l];
            }
        }
        else {
            for (l = i; l <= mid; l++) {
                buff[k++] = arr[l];
            }
        }
        for (l = left; l <= right; l++) {
            arr[l] = buff[l];
        }

    }
}
