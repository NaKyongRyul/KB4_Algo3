package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650_N과M1_이채림 {

	// 중복 허용 X
	static int[] arr;
	static int R; // 선택개수
	static int N;
	static int[] selection; // 현재 선택한 요소
	static boolean[] isSelected; // 마킹배열 - 선택했는지 체크

	static void combination(int r, int start) {

		if (r == R) {
			for (int i = 0; i < R; i++)
				System.out.print(arr[selection[i]] + " "); // 결과 출력
			System.out.println();
			return;
		}

		for (int i = start; i < arr.length; i++) {// start부터 시작해야 인덱스가 작은 값을 안 뽑음
			if (isSelected[i])
				continue; // 중복인 경우 skip
			isSelected[i] = true; // 중복 마킹
			selection[r] = i; // 선택
			combination(r + 1, i); // 다음 재귀로
			isSelected[i] = false; // 선택한걸 되돌려줘야 함
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		R = Integer.parseInt(st.nextToken());
		selection = new int[R];
		isSelected = new boolean[arr.length];

		combination(0, 0);

	}
}
