package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기_오원식 {

	static int N;
	static int M;
	static int[] num;
	static int[] findNum;

	// 직접 이진탐색 구현
	public static int count(int start, int end, int target) {

		while (start <= end) {
			int mid = (start + end) / 2;

			if (num[mid] == target)
				return 1;
			else if (num[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return 0;
	}

	// 내장함수 이용해서 구현
	public static int valid(int find) {
		if (Arrays.binarySearch(num, find) >= 0)
			return 1;
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(s[i]);
		Arrays.sort(num);

		M = Integer.parseInt(br.readLine());
		findNum = new int[M];

		s = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			findNum[i] = Integer.parseInt(s[i]);

		for (int i = 0; i < M; i++)
			System.out.println(count(0, N - 1, findNum[i]));
		// System.out.println(valid(findNum[i]));
	}

}
