package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min;
        int idx = 0;

        for (int i = 0; i < N - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            if (min < arr[i]) {
                swap(arr, i, idx);
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
