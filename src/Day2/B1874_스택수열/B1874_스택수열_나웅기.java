package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B1874_스택수열_나웅기 {
	public static void main(String[] args) throws IOException{
			
			Stack<Integer> stack = new Stack<>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(reader.readLine());
			int [] arr = new int [n];
			for (int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(reader.readLine());
			}
			ArrayList<String> result = new ArrayList<>();
			int idx = 0;
	
			for (int i = 1; i<n+1; i++) {
				stack.add(i);
				result.add("+");
				while (!stack.isEmpty() && arr[idx]==stack.peek()) {
					stack.pop();
					result.add("-");
					if (idx<n-1) idx++;
	
				}
			}
			if (stack.isEmpty()) {
				for (String i : result) {
					System.out.println(i);
				}
			} else {
				System.out.println("NO");
			}
			
	
	
	}
}
