package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608_막대기_서지수 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		Stack<Integer> stack=new Stack<>();
		
		
		int N=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			stack.add(Integer.parseInt(st.nextToken()));
		}		
		
		int peek=stack.peek();
		Stack<Integer> new_stack=new Stack<>();
		new_stack.add(peek);
		
		while(!stack.empty()) {
			int pop=stack.pop();
			if(pop>peek) {
				peek=pop;
				new_stack.add(pop);
			}
		}	
		
		System.out.println(new_stack.size());

	}

}
