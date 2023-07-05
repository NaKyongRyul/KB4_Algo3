package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_삽입정렬_신선영 {

	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void insertionSort(int[] arr) {
		// 인덱스는 앞에서부터 탐색 (1부터 시작)
		int len = arr.length;

		// 현재 기준으로 앞의 값을 확인하며 더 작은 값을 만나면 위치 선정
		for (int i = 1; i < len; i++) {
			while (i > 0 && arr[i - 1] > arr[i]) {
				swap(arr, i, i - 1);
				i--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 처리
		int N = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		insertionSort(arr);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
