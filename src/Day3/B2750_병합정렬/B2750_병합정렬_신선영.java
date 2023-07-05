package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_병합정렬_신선영 {
	static void mergeSort(int[] arr, int[] temp, int start, int end) {
		// start가 더 커진 경우 (분할 끝난 경우 return)
		if (start >= end) return;

		// divide
		int mid = (start + end) / 2;
		mergeSort(arr, temp, start, mid);
		mergeSort(arr, temp, mid + 1, end);

		// conquer
		int left = start;
		int right = mid + 1;
		int idx = start;    // 실제 삽입할 인덱스

		while (left <= mid || right <= end) {
			// left가 먼저 mid보다 커진 경우: right 소진
			if (left > mid) {
				temp[idx++] = arr[right++];
			}

			// right가 먼저 end보다 커진 경우: left 소진
			else if (right > end) {
				temp[idx++] = arr[left++];
			}

			// 작은 수부터 정렬 기준 -> left가 더 크면 right 먼저 삽입
			else if (arr[left] > arr[right]) {
				temp[idx++] = arr[right++];
			}

			else if (arr[left] < arr[right]) {
				temp[idx++] = arr[left++];
			}
		}

		// 완료한 후에는 arr에 temp 반영시키는 것 잊지 말 것!
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
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
		int[] sorted = new int[N];
		mergeSort(arr, sorted, 0, N - 1);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
