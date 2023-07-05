package Day2.B1874_스택수열;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열_조성환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder str = new StringBuilder();	
		
		Stack<Integer> stack = new Stack<>();
		
		int N = in.nextInt();
		
		int start = 0;
		int K = 0;
		while(K < N) {
			K++;
			int value = in.nextInt();
			
			if(value > start) {
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					str.append('+').append('\n');	
				}
				start = value; 	
			}
			
			
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;		
			}
			
			stack.pop();
			str.append('-').append('\n');
			
		}
		
		System.out.println(str);
	}
}
