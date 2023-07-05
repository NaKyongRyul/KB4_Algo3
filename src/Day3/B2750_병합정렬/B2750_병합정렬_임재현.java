package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2750_병합정렬_임재현 {
    static void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;

        int center = n / 2;

        int[] leftArr = new int[center];
        int[] rightArr = new int[n - center];
        for (int i = 0; i < center; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = center; i < n; i++) {
            rightArr[i - center] = arr[i];
        }

        mergeSort(leftArr, center);
        mergeSort(rightArr, n - center);

        int leftIdx = 0;
        int rightIdx = 0;
        int mainIdx = 0;
        while (leftIdx < center && rightIdx < n - center) {
            if (leftArr[leftIdx] < rightArr[rightIdx]) {
                arr[mainIdx++] = leftArr[leftIdx++];

            } else {
                arr[mainIdx++] = rightArr[rightIdx++];
            }
        }
        while (leftIdx < center) {
            arr[mainIdx++] = leftArr[leftIdx++];
        }
        while (rightIdx < n - center) {
            arr[mainIdx++] = rightArr[rightIdx++];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, N);

        for (int i = 0; i < N; i++) {
            builder.append(arr[i]).append("\n");
        }
        System.out.print(builder);
    }
}