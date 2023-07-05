package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_서은효 {

	
	public static void main(String[] args) throws IOException {

		
		Queue <Integer> que = new ArrayDeque<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine()," ");
		StringBuilder builder = new StringBuilder();
		

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		

		//que에다 값 넣기 
		for(int i =1; i<=N ; i++) {
			que.offer(i);
		}	
		
		int k = 1;
		
		while(que.size() != 1) {
		
			
			//k가 3이면 추출
			if(k == K) {
				builder.append(que.poll()+", ");		
				k = 0;
			}
			
			//k가 3이 아니라면 que 맨 뒤로 보내기 
			else que.offer(que.poll());
			System.out.println(que.toString());
			//k = k + 1
			k++;

		}
		
		// 사이즈가 1일 때 추출 후 builder에 저장 
		builder.append(que.poll());
		
		
		// 뽑은 값 출력
		System.out.println("<"+ builder.toString()+">");
		
	}
}
