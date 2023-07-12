package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class B1874_스택수열_오원식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Queue <String> que = new ArrayDeque<>();
		
		int cnt = 1;
		
		for(int i = 0; i < n; i++) {
			while(cnt <= arr[i]) {
				stack.push(cnt);
				cnt ++;
				que.offer("+");
			}
			
			if(stack.peek() == arr[i]) {
				stack.pop();
				que.offer("-");
			}
			
			else {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		int size = que.size();
		
		for(int i = 0; i < size; i++) {
			System.out.println(que.poll());
		}
		
	}
}
