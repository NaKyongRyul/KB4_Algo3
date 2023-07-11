package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_정지원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxHeight=0;
		int answer = 0;
		
		Stack<Integer> stack =new Stack<>();
		
		for(int i=0;i<n;i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int temp;
		for(int i=0;i<n;i++) {
			temp = stack.pop();
			if(maxHeight<temp) {
				answer++;
				maxHeight = temp;
			}
		}
		System.out.println(answer);
		
	}
}
