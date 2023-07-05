package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_퀵정렬_박창현 {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int s, int e) {
        if (s>=e)return;
        int l = s + 1, r = e;
        while (l <= r) {
            while (l <= r&&arr[l] < arr[s]) l++;
            while (l <= r&&arr[r] > arr[s]) r--;
            if (r>l) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        swap(arr, s, r);
        quickSort(arr, s, r - 1);
        quickSort(arr, r + 1, e);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
