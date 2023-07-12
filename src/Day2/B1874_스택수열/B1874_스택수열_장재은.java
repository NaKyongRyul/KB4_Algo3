package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874_스택수열_장재은 {

	public static void main(String[] args) throws IOException {
		Stack <Integer> stack = new Stack<>();
		Stack <String> arrResult = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tk.nextToken());
		int k = 1;
		boolean temp = true;
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine());			
			int num = Integer.parseInt(tk.nextToken());
			while(k <= num) {
				stack.add(k);
				arrResult.add("+");
				k += 1;
			}
			if(num == stack.peek()) {
				stack.pop();
				arrResult.add("-");
			} else {
				temp = false;
				break;
			}
		}
		if(temp == true)
			for(String s : arrResult)
				System.out.println(s);
		else System.out.println("NO");	
	}
}