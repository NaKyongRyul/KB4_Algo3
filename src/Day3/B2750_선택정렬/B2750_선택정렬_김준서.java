package Day3.B2750_선택정렬;

import java.util.Scanner;

public class B2750_선택정렬_김준서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < N; i++) {
            int least = arr[i - 1];
            int leastIdx = i-1;
            for (int j = i; j < N; j++) {
                if (least > arr[j]) {
                    least = arr[j];
                    leastIdx = j;
                }
            }
            swap(arr, i - 1, leastIdx);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}

