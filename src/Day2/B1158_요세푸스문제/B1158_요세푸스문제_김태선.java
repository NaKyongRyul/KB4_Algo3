package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_김태선 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList <Integer> arr = new ArrayList <> ();
		Queue<Integer> que = new LinkedList<Integer> ();
		int idx = -1;
		
		for(int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		do {
			for (int i = 0; i < K; i++) {
				idx++;
				
				if(idx == arr.size()) {
					idx = 0;
				}
			}
			que.add(arr.get(idx));
			arr.remove(idx);
			idx -= 1;
			
		}while(!arr.isEmpty());
		
		if(N == 1) {
			System.out.println("<" + que.poll() + ">");
			return;
		}
		
		System.out.print("<" + que.poll() + ",");
		
		for(int i = 0; i < N - 2; i++) {
			System.out.print(" " + que.poll() + ",");
		}
		
		System.out.print(" " + que.poll() + ">");
	}
	
}