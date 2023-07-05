package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2493_탑_박예린 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String [] s = br.readLine().split(" ");
		
		Stack <Integer> stack = new Stack<>();
		Stack <Integer> stack_tmp = new Stack<>();
		
		int [] res = new int [N];

		int len = s.length;
		
		for(int i = 0; i < len; i++) {
			stack.add(Integer.parseInt(s[i]));
		}

		int cnt = N;
		int index = 0;
		int top = 0;

		while(!stack.isEmpty()) {
			top  = stack.pop();
			cnt = N-index;
			
			while(!stack.isEmpty()) {
				cnt--;
				if(stack.peek() > top) {
					res[N-index-1] = cnt;

					break;
				} else {
					stack_tmp.add(stack.pop());	
				}
			}
			while(!stack_tmp.isEmpty()) {
				stack.add(stack_tmp.pop());
			}
			index++;
		}
		
		for(int i = 0; i < len; i++) {
			System.out.print(res[i]);
			if(i < len - 1) System.out.print(" ");
		}
	}
}
