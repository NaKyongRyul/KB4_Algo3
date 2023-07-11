package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_정지원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int pointer=0;
		StringBuilder str = new StringBuilder();
		

		
		for(int i=0;i<n;i++) {
			stack.push(i+1);
			str.append("+\n");
			while(pointer<n&&stack.size()!=0) {
				if(arr[pointer]==stack.peek()) {
					stack.pop();
					pointer++;
					str.append("-\n");					
				}
				else {
					break;
				}
			}
			
		}
		if(stack.size()==0) {
			System.out.println(str.toString());
		}
		else {
			System.out.println("NO");
		}
	}
}
