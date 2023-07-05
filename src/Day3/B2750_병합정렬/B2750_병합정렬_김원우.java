package Day3.B2750_병합정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_병합정렬_김원우 {
    public static void merge_sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left+right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int [] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid+1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right+1);
        int i = 0;
        int j = 0;
        int k = left;

        while (leftArr.length > i && rightArr.length > j) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        merge_sort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
