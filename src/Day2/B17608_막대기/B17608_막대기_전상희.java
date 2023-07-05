package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_전상희 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(bf.readLine()));
		}
		//System.out.println(stack);
		
		int num = stack.pop();
		int ans = 1;
		while(!stack.isEmpty()) {
			int a = stack.pop();
			if(a>num) {
				ans++;
				num = a;
			}
		}
		
		System.out.println(ans);
	}
}
