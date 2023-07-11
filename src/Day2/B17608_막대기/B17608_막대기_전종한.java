package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_전종한 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		Stack <Integer> stack = new Stack<>();

		for(int i=0; i<N; i++) stack.add(Integer.parseInt(bf.readLine()));

		int max_height = stack.pop();
		int cnt = 1;

		while(!stack.isEmpty()) {
			int height = stack.pop();
			if(height > max_height) {
				cnt ++;
				max_height = height;
			}
		}

		System.out.println(cnt);

	}
}
