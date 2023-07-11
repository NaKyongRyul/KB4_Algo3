package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1874_스택수열_전민형 {

	public static void main(String[] args) throws IOException {

		Queue <String> que = new LinkedList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		str = reader.readLine();
		int num = Integer.parseInt(str);
		int [] arr = new int[num];
		int i;
		
		Stack <Integer> stack1 = new Stack<>();
		Stack <Integer> stack2 = new Stack<>();
		
		for(i = num; i>=1; i--) {
			stack1.add(i);
		}
		
		
		for(i = 0; i<num; i++) {
			str = reader.readLine();
			arr[i] = Integer.parseInt(str);
			
		}
		
		i=0;
		
		while(true) {

			if(!(stack1.isEmpty())) {

				if(!(stack2.isEmpty())) {

					if(stack2.peek()==arr[i]) {

						stack2.pop();
						que.add("-");
						i++;

					}
					else {

						stack2.add(stack1.pop());
						que.add("+");

					}
				}
				else {
					
					stack2.add(stack1.pop());
					que.add("+");

				}
			}
			else if(stack1.isEmpty()) {

				if(stack2.isEmpty()) {
					
					break;

				}
				else if(stack2.peek()==arr[i]) {

					stack2.pop();
					que.add("-");
					i++;

				}
				else {
					break;
				}

			}

		}
		
		if(stack2.isEmpty()) {
			
			while(!que.isEmpty()) {
				
				System.out.println(que.poll());
				
			}
			
		}else System.out.println("NO");
		
	}

}