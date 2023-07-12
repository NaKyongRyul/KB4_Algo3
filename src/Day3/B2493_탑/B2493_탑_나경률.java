package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_나경률 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Top> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			int nowHeight = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(nowHeight <= stack.peek().height) {
					sb.append(stack.peek().num + " ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.add(new Top(i, nowHeight));
		}
		System.out.println(sb);
	}
}

class Top {
	int num;
	int height;
	
	Top(int num, int height) { 
		this.num = num;
		this.height = height;
	}
}