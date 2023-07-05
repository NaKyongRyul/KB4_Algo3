package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_윤소민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(bf.readLine());
		for(int i=0;i<N;i++) {
			stack.push(Integer.parseInt(bf.readLine()));
		}
		//System.out.println(stack);
		int h = stack.peek();
		int cnt=1;
		for(int i=0;i<N;i++) {
			int pop_value = stack.pop();
			if(pop_value>h) {
				cnt++;
				h = pop_value;
			}
			//System.out.println(stack);
		}
		System.out.println(cnt);

	}

}
