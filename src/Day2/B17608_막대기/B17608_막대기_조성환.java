package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608_막대기_조성환 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(bf.readLine());
		for (int i = 0 ; i < N ; i++) {
			int Building = Integer.parseInt(bf.readLine());
			while(true) {
				if (stack.isEmpty()) {
					stack.push(Building);
					break;
				}else if(Building >= stack.peek()) {
					stack.pop();
				}else {
					stack.push(Building);
					break;
				}
			}
		}
		System.out.println(stack.size());
	}
}
