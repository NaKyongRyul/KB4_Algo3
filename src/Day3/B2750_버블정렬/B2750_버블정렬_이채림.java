package Day3.B2750_버블정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_버블정렬_이채림 {

	public static void bubbleSort(int[] arr, int n) {
		int cnt = 0;

		while (n!=0) {
			for (int i = 1; i < n; i++) {
				if (arr[i] < arr[i - 1]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}

			}n--;
		}
	}

	public static void main(String[] args) {
		// 입력처리
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr, N);
		for(int i : arr) {
			System.out.println(i);
		}

	}

}
