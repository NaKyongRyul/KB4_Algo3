package Day3.B2750_퀵정렬;

import java.util.Scanner;

public class B2750_퀵정렬_김원우 {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int lo = left;
        int hi = right;

        while (lo < hi) {

            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }
            while (arr[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(arr, lo, hi);
        }

        swap(arr, left, lo);
        return lo;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, pivot + 1, right);
        quickSort(arr, left, pivot-1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
