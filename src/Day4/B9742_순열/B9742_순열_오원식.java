package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B9742_순열_오원식 {

	static ArrayList<StringBuilder> answer = new ArrayList<>();
	static String[] arr;
	static int N;
	static int[] select;
	static boolean[] isSelected;

	public static void permutation(int r) {

		// 종료조건
		if (r == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < select.length; i++)
				sb.append(arr[select[i]]);
			answer.add(sb);
			return;
		}

		// 재귀확장
		for (int i = 0; i < arr.length; i++) {

			// 선택한 경우 = skip
			if (isSelected[i] == true)
				continue;

			// 선택
			select[r] = i;
			isSelected[i] = true;
			permutation(r + 1);

			// 선택 해제
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();

			if (s == null)
				break;

			String[] str = s.split(" ");

			arr = str[0].split("");
			int n = Integer.parseInt(str[1]);

			N = arr.length;

			select = new int[N];
			isSelected = new boolean[arr.length];

			permutation(0);
			
			StringBuilder sb = new StringBuilder();
			sb.append(str[0]).append(" ");
			sb.append(n).append(" = ");
			
			if (answer.size() > n - 1) {
				sb.append(answer.get(n - 1));
				System.out.println(sb);
			} else {
				sb.append("No permutation");
				System.out.println(sb);
			}

			answer.clear();
		}

	}

}
