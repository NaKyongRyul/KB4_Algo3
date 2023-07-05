package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_윤상우 {

	// pop 아이디어로 다시 풀어보기
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long arr [] = new long [n];
		int ht [] = new int [n];
		Stack<Long> stack = new Stack<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.add(arr[0]);
		long top = arr[0];
		int top_size = 0;
		
		for(int i=1; i<n; i++) {
			if(stack.peek() < arr[i]) {
				if(top < arr[i]) {
					top = arr[i];
					ht[i] = 0;
					top_size = stack.size()+1;
				}else {
					ht[i] = top_size;
				}
			}else {
				if(stack.peek() < top) {
					ht[i] = stack.size();
				} else {
					ht[i] = top_size;
				}
			}
			stack.add(arr[i]);
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(ht[i] + " ");
		}
		
		
	}

}
