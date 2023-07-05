package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_삽입정렬_서지수 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void InsertionSort(int[] arr, int N) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					for (int j = 0; j < i + 1; j++) {
						if (arr[i + 1] < arr[j]) {
							swap(arr, i + 1, j);
						}
					}
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		InsertionSort(arr, N);

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}

	}

}
