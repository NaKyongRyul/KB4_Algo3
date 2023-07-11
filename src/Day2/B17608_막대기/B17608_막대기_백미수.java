package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_백미수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); //막대기의 개수

		int h = 0; //막대기 높이
		
		Stack<Integer> stack = new Stack<Integer>();//막대기들 넣기
		
		for(int i =0; i<N; i++) {
			h = Integer.parseInt(reader.readLine());
			stack.push(h);
		}
		int first_peek = stack.peek();
		
		int count = 0;
		int second_peek = 0;
		for(int i =N-1; i>=0; i--) {
			if(stack.get(i)>first_peek && stack.get(i)>second_peek) {
				count++;
				second_peek = stack.get(i);
			}
		}
		System.out.println(count+1);
	}
}
