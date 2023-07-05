package Day6.B1920_수찾기;

import java.util.Arrays;
import java.util.Scanner;

public class B1920_수찾기_이채림 {
	static int N;
	static int M;
	static int[] arr;
	static int low;
	static int high;

	static int BinarySearch(int target) {
		low = 0;
		high = N - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return 1;
			}
			else if (arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();// 배열 개수
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		M = sc.nextInt(); // 배열 안에서 찾을 개수
		
		for (int i = 0; i < M; i++) {
			int val = sc.nextInt();
			BinarySearch(val);
		

		}
	}

}
