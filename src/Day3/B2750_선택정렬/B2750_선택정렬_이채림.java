package Day3.B2750_선택정렬;

import java.util.Scanner;

public class B2750_삽입정렬_이채림 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int j;//j for문 밖에서도 j의 값이 필요할 때 포문 밖에 선언!!!
			int tmp = arr[i];//미리 i번째 배열의 값을 백업해둔다.
			
			for (j = i; j > 0 && arr[j - 1] > tmp; j--) // while문으로 돌려도 됨
				arr[j] = arr[j - 1];
			arr[j] = tmp;
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
		insertionSort(arr, N);
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
