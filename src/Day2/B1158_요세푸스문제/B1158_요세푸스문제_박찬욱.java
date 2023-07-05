package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		
		int N = Integer.parseInt(token.nextToken()); // 사람의 수
		int K = Integer.parseInt(token.nextToken()); // 제거되는 순서
		
		Queue <Integer> que = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) que.add(i); // 원을 이루면서 앉음
		
		StringBuilder ans = new StringBuilder();
		
		while(!que.isEmpty()) {
			for(int j = 0; j < K-1; j++) {
				que.add(que.remove());
			}	
			if(que.size() == 1)	ans.append(que.remove());
			else ans.append(que.remove() +  ", ");
			
		}
		System.out.println("<" + ans + ">");
	}
}
