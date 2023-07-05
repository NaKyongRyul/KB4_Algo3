package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_Sol {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력처리 //
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(io.readLine());
		int [] arr = new int [N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(io.readLine());
		
		// 스택 이용 //
		Stack <Integer> stack = new Stack<>();
		for(int i=0; i<N; i++){
			int now = arr[i];
			while(!stack.isEmpty() && now >= stack.peek())
				stack.pop();
			stack.push(now);
		}
		
		// 정답 출력 //
		System.out.println(stack.size());
	}
}
