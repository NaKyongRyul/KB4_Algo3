package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_나경률 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Integer> stack = new Stack<>();
			
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			stack.add(Integer.parseInt(br.readLine()));
		}
		
		int kizun = stack.pop();
		int count = 1;
		
		while(!stack.isEmpty()) {
			int pop_value = stack.pop();
			if(kizun < pop_value) {
				count++;
				kizun = pop_value;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}

}
