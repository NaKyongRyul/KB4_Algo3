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
		Stack<Integer> stack01 = new Stack<>();
		Stack<Integer> stack02 = new Stack<>();
		Stack<Integer> answer =new Stack<>();
		Deque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt( bf.readLine());
		
		String s = bf.readLine();
		String []str = s.split(" ");
		for(int i=0; i<N;i++) {
			queue.add(Integer.parseInt(str[i]));
			stack01.push(Integer.parseInt(str[i]));
			
		}
		int index= 0;
		int idx=0;
		answer.add(0);
		while(answer.size()!=N) {
			if(!queue.isEmpty()) {
				int top = queue.remove();
				index++; //1
				idx++;
				System.out.println(top);  // 6
				System.out.println(queue.peek());  // 9
				if(top >queue.peek()) {
					answer.add(stack01.indexOf(queue.peek()));
					idx = index;
					
				}
				
				else {
					System.out.println("i : "+idx);
					if(--idx>0 && answer.get(idx)>0) {
						System.out.println("x "+answer.get(idx));
						answer.add(idx);
					}
					else
						answer.add(0);
				}
				System.out.println(answer.toString());
			}
			
		}
//			
//		while(index >=0) {
//			int top = stack01.pop();
//			while(!stack01.isEmpty()) {
//				if(top < stack01.peek()) {
//					answer[index] = stack01.indexOf(stack01.peek())+1;
//					break;
//				}
//				else {
//					stack02.add(stack01.pop());
//				}
//			}
//			while(!stack02.isEmpty())
//				stack01.add(stack02.pop());
//			index--;
//		}
//		for(int i=0;i<N;i++)
//			System.out.print(answer[i]+ " ");
		
	}

}
