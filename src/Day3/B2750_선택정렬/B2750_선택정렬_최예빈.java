package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_최예빈 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        selectSort();

        for (int i = 0; i < N; i++) System.out.println(arr[i]);
    }

    private static void selectSort() {
        for (int a = 0; a < N - 1; a++) {
            for (int b = a + 1; b < N; b++) {
                if (arr[a] > arr[b]) {
                    swap(a, b);
                }
            }
        }
    }

    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
