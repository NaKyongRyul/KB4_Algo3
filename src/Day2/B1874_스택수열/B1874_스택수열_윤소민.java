package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B1874_스택수열_윤소민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		//4 3 6 8 7 5 2 1 
		StringBuilder sb = new StringBuilder();
		int[] ans = new int[n];
		for(int i=0;i<n;i++) {
			ans[i] = Integer.parseInt(bf.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();
		
		int start =1;
		for(int i=0;i<n;i++) {
			if(start<=ans[i]) {
				for(int j=start;j<ans[i]+1;j++) {
					stack.push(j);
					start++;
					sb.append("+"+"\n");
				}				
				
			}
			else if(ans[i] !=stack.peek()) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-"+"\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
