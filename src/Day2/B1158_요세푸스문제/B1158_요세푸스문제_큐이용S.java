package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_큐이용S {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		str.append('<');
		
		Queue <Integer> que = new ArrayDeque<>();
		
		for(int i =1; i<N+1; i++) que.add(i);
		
		int idx=0;
		while(!que.isEmpty()) {
			if(++idx%K==0) str.append(que.poll() + ", ");
			else que.offer(que.poll());
		}
		
		str.delete(str.length()-2, str.length());
		str.append(">");
		System.out.println(str.toString());
	}


	
}
