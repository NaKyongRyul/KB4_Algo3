package Day3.B2750_선택정렬;

import java.util.Scanner;

public class B2750_선택정렬_김원우 {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < len; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            swap(arr, i, min_idx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
