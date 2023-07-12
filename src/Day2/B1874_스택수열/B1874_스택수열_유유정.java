package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1874_스택수열_유유정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack <Integer> stack = new Stack<>();
		Queue <String> answer = new LinkedList<>();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int [] arr = new int [n];
		
		for(int i=0;i<n;i++)
			 arr[i] = Integer.parseInt(bf.readLine());
		int index =0;
		int count = 1;
		stack.add(1);
		answer.add("+");
		while(index <n) {		
			if(stack.isEmpty()) {
				count++;
				stack.push(count);
				answer.add("+");

			}
			if(count == n+1) break;
				
			if(arr[index]== stack.peek()) {
				stack.pop();
				answer.add("-");
				index++;
			}
			else if(arr[index]<stack.peek()) {
				stack.pop();
				answer.add("-");
				
			}
			else {
				count++;
				stack.add(count);
				answer.add("+");
				
			}

			
		}
		if(stack.isEmpty()) {
			while(!answer.isEmpty())
				System.out.println(answer.poll());
		}
		else {
			System.out.println("NO");
		}
	}

}