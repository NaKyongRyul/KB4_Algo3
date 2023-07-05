package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_이우엽 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		// stack에 입력받은 값 push
		for(int i = 0; i < N; i++) {
			int element = Integer.parseInt(bf.readLine());
			stack.push(element);
		}
		
		int viewCnt = 1;
		// 맨위의 기준이 되는 높이 pop
		int standard = stack.pop();
		
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			if(current > standard) {
				standard = current;
				viewCnt++;
			}
		}
		
		System.out.println(viewCnt);

	}

}
