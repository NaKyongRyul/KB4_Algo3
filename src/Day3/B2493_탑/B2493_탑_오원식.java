package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B2493_탑_오원식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String[] str = s.split(" ");

		Stack<Integer> top = new Stack<>();
		int[] ans = new int[N];
		top.push(Integer.parseInt(str[0]));

		for (int i = 1; i < N; i++) {
			while (!top.isEmpty() && top.peek() < Integer.parseInt(str[i])) {
				top.pop();
			}

			if (!top.isEmpty()) {
				ans[i] = Arrays.asList(str).indexOf(Integer.toString(top.peek())) + 1;
			}

			top.push(Integer.parseInt(str[i]));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);

	}

}
