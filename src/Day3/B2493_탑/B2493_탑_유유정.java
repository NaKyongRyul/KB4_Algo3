package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class B2493_탑_유유정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt( bf.readLine());
		
		String s = bf.readLine();
		String []str = s.split(" ");
		int [] arr = new int [N];
		int [] answer = new int [N];
		for(int i=0; i<N;i++) {
			arr[i] = (Integer.parseInt(str[i]));			
		}
		for(int i=0;i<N;i++) {
			int now =arr[i];
			if(stack.isEmpty()) {
				stack.add(i);
				answer[i]=0;
				System.out.println(answer[i]);
				continue;
			}
			while(!stack.isEmpty() && arr[stack.peek()]<now) {
				stack.pop();
				
			}
			
			if(!stack.isEmpty()) {
				answer[i] = stack.peek()+1;
				stack.push(i);
					
			}
				
			
		}
		
		for(int i=0;i<N-1;i++) {
			System.out.print(answer[i]+ " ");
		}
		System.out.println(answer[N-1]);
	}

}
