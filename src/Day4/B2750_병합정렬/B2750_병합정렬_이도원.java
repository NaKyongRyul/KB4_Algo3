package Day4.B2750_병합정렬;

import java.io.*;

public class B2750_병합정렬_이도원 {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int tmpSize = right - left + 1;
        int[] tmp = new int[tmpSize];

        int start = left;
        int end = mid + 1;

        int idx = 0;
        while(idx < tmpSize){
            if (start > mid || (end <= right && arr[start] > arr[end])) {
                tmp[idx] = arr[end];
                end++;
            }
            else if (end > right || (left <= mid && arr[start] < arr[end])) {
                tmp[idx] = arr[start];
                start++;
            }
            idx++;
        }

        for (int i = left; i <= right; i++){
            arr[i] = tmp[i - left];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, n - 1);

        for (int num : arr) {
            System.out.println(num);
        }
    }
}