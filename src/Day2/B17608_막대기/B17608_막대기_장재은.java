package Day2.B17608_막대기;

import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기_장재은 {

	public static void main(String[] args) {
		
		Stack <Integer> stack = new Stack<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) stack.push(sc.nextInt());
		
		int cnt = 0;
		int height = 0;
		
		while(!stack.isEmpty()) {
			int pop_num = stack.pop();
			if(pop_num > height) {
				cnt++;
				height = pop_num;
			}	
		}
		System.out.println(cnt);
		sc.close();
	}
}
