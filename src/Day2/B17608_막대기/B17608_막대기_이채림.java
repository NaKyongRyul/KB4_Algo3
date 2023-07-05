package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_이채림 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int max = 0, cnt = 0, pop = 0;
		
		Stack <Integer> stack = new Stack<>();
		
		for(int i =0; i < N; i++) {
			stack.push(Integer.parseInt(bf.readLine()));
		}
		//System.out.println(stack);
		
		while(!stack.isEmpty()) {
			pop = stack.pop();
			if(pop > max) {
				max = pop;
				cnt++;}
			}
		System.out.println(cnt);
		}


}
