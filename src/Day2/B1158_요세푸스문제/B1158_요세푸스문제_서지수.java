package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_서지수 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		Queue<Integer> que=new ArrayDeque<>();
		Queue<Integer> result=new ArrayDeque<>();
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int arr[]=new int[N];
		

		for(int i=1;i<=N;i++) {
			que.add(i);
		}
		
		int cnt=1;
		
		while(!que.isEmpty()) {
			if(cnt==K) {
				int poll=que.poll();
				result.add(poll);
				cnt=1;
				
			}
			
			else {
				int poll=que.poll();
				que.add(poll);
				cnt++;
			}
		}


		System.out.print("<");
		while(!result.isEmpty()) {
			int poll=result.poll();
			System.out.print(poll);
			if(result.size()>=1) {
				System.out.print(", ");
			}
			
		}
		
		System.out.println(">");
	}
}
