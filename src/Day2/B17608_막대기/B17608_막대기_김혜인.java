package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_김혜인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
		int N  = Integer.parseInt(br.readLine());
		Stack <Integer> stack = new Stack<>();
		
		//막대기 높이 구하기
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		// 보이는 막대기 구하기
		
		
		int peek = stack.pop();
		
		while(!stack.isEmpty())
		{
			int pop_value = stack.pop();
			
			if(pop_value>peek){
				peek = pop_value;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
