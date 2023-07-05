package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_병합정렬_박창현 {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int m = (s + e) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        int[] tmp = new int[e - s + 1];
        int l = s, r = m + 1, idx = 0;
        while (l <= m && r <= e) {
            if (arr[l] <= arr[r]) tmp[idx++] = arr[l++];
            else tmp[idx++] = arr[r++];
        }
        while (l <= m) tmp[idx++] = arr[l++];
        while (r <= e) tmp[idx++] = arr[r++];
        for (int i = 0; i < e - s + 1; i++) {
            arr[i + s] = tmp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
