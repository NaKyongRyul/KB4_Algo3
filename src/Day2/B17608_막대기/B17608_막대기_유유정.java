package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_유유정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack <Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<N;i++)
			 stack.add(Integer.parseInt(bf.readLine()));
		int stick = 0;
		int count =0;
		for(int i=0;i<N;i++) {
			int top = stack.pop();
			if(top>stick) {
				stick = top;
				count ++;
			}
		}
		System.out.println(count);
			
			
		
	}

}
