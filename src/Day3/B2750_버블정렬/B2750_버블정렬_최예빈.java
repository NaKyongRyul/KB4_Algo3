package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_버블정렬_최예빈 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        bubbleSort();

        for (int i = 0; i < N; i++) System.out.println(arr[i]);
    }

    public static void bubbleSort() {
        boolean again = true;
        while (again) {
            again = false;
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i);
                    again = true;
                }
            }
        }
    }

    private static void swap(int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
