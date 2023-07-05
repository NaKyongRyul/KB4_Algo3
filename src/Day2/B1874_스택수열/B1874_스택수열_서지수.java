package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Queue;

public class B1874_스택수열_서지수 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		Stack<Integer> stack=new Stack<>();
		Queue<String> result=new ArrayDeque<>();
		
		int n=Integer.parseInt(st.nextToken());
		int arr[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(bf.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int idx=1;
		int value=0;
		int cnt=0;
		boolean isNo = false;
		
		while(idx<=n) {
			if(cnt>n+1) {
				isNo=true;
				break;
			}
		
			if(stack.isEmpty()) {
				++value;
				stack.push(value);
				result.add("+");
				
			}
			else {
				if(stack.peek().equals(arr[idx])) {
					stack.pop();
					result.add("-");
					idx++;
				}
				else {
					++value;
					stack.push(value);
					result.add("+");
					cnt++;		
					
				}
			}
			
		}
		
		if(isNo) {
			System.out.println("NO");
		}
		else {
			while(!result.isEmpty()) {
				System.out.println(result.poll());
			}
			
		}
	}

}
