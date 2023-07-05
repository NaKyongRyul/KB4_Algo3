package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_김태선 {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>(); 
		Stack<Integer> no = new Stack<>(); 
		
		int N = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int [N+1]; 
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int top = 0; 
		for(int j = 1; j < nums.length; j++) {
			
			if(stack.isEmpty()) { 
				stack.push(nums[j]); 
				no.push(j); 
				sb.append(0 + " ");	
			} 
			else {
				top = stack.peek(); 
				
				if(top > nums[j]) { 
					sb.append(no.peek() + " "); 
					stack.push(nums[j]); 
					no.push(j); 
				}	
		
				else if(top < nums[j]) { 
					stack.pop(); 
					no.pop(); 
					j--; 
					continue; 
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1); 
		System.out.print(sb);
		
		
		
	}

}
