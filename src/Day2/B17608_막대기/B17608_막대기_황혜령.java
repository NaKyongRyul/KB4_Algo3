package Day2.B17608_막대기;

import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기_황혜령 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < n; i++) {
			s.push(sc.nextInt());
		}
		int max = 0, cnt = 0;
		while(!s.empty()) {
			if(max < s.peek()) {
				max = s.pop();
				cnt++;
			}
			else
				s.pop();
		}
		
		System.out.println(cnt);
	}
}
