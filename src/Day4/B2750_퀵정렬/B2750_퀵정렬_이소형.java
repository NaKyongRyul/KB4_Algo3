package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_이소형 {

    public static int[] arr;

    public static int partition(int left, int right) {

        int temp, idx = left;
        int pivot = arr[left++];

        while (left <= right) {
            for (; left <= right && arr[left] < pivot; left++) {

            }
            for (; left <= right && arr[right] > pivot; right--) {

            }

            if (left < right) {

                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[idx] = arr[right];
        arr[right] = pivot;
        return right;
    }

    public static void quickSort(int left, int right) {

        if (left >= right) return;
        int pivot = partition(left, right);
        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        quickSort(0, n - 1);

        for (int e :
                arr) {
            System.out.println(e);
        }
    }
}
