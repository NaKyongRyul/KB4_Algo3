package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_오원식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Stack <Integer> stack = new Stack<>();
		for (int i = 0; i<N; i++) 
			stack.push(Integer.parseInt(bf.readLine()));
		
		int cnt = 1;
		int right = stack.peek();
		
		while(!stack.empty()) {
			if(stack.peek()>right) {
				right = stack.pop();
				cnt ++;
			}
			else stack.pop();
		}
		
		System.out.println(cnt);
	}

}
