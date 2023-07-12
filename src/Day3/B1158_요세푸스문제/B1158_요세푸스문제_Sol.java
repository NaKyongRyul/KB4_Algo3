package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_Sol {
	public static void main(String[] args) throws IOException {

		  // 입력 처리 //
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine() , " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			StringBuilder str = new StringBuilder();
			str.append('<');
			
			// Queue 초기화 (1부터 N 까지 추가) //
			Queue <Integer> que = new ArrayDeque<>();
			for(int i =1; i<N+1; i++) que.add(i);
			
			// while 문으로 구현 //
			int idx=0;
			while(!que.isEmpty()) {
				int poll_value = que.poll();
				if(++idx%K==0) str.append(poll_value + ", ");
				else que.offer(poll_value);
//				System.out.println(poll_value + " " + str);
			}
			
			str.delete(str.length()-2, str.length());
			str.append(">");
			System.out.println(str.toString());
		}

}
