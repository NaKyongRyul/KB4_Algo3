package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length - 1);

        for (int element : arr) {
            System.out.println(element);
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;

            if (left < right) swap(arr, left, right);
        }

        swap(arr, start, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
