package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_나웅기 {
	public static void main(String[] args) throws IOException{
		Stack<Integer> stack = new Stack<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(reader.readLine()));
		}
		int result = 1;
		int top = stack.peek();
		while (!stack.isEmpty()) {
			int tall = stack.pop();
			if (tall > top) {
				top = tall;
				result++;
			}
		}
		System.out.println(result);
	}
}
