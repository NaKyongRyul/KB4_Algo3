package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_김태선 {

	public static void main(String[] args) throws Exception, IOException {
		
		Stack <Integer> stack = new Stack <> ();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//String str = bf.readLine();
		int N = Integer.parseInt(bf.readLine());
		
		int h = 0;

		for(int i = 0; i < N; i++) {
			//str = bf.readLine();
			h = Integer.parseInt(bf.readLine());
			stack.push(h);
		}
		
		
		int pop = stack.pop();
		int cnt = 1;
		int current = 0;
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(current > pop) {
				pop = current;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
