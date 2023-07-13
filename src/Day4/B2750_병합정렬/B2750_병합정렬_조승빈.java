package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, tmp, 0, arr.length - 1);

        for (int element : arr) {
            System.out.println(element);
        }
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(arr, tmp, start, mid);
        mergeSort(arr, tmp, mid + 1, end);

        merge(arr, tmp, start, mid, end);
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        tmp = Arrays.copyOf(arr, arr.length);

        int leftIdx = start;
        int rightIdx = mid + 1;
        int arrIdx = start;

        while (leftIdx <= mid && rightIdx <= end) {
            if (tmp[leftIdx] <= tmp[rightIdx]) {
                arr[arrIdx] = tmp[leftIdx];
                leftIdx++;
            } else {
                arr[arrIdx] = tmp[rightIdx];
                rightIdx++;
            }
            arrIdx++;
        }

        while (leftIdx <= mid) {
            arr[arrIdx] = tmp[leftIdx];
            leftIdx++;
            arrIdx++;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
