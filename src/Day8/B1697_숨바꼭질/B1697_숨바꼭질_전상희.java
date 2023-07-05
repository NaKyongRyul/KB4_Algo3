package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질2 {
	static int N;
	static int K;
	static int count[] = new int[100100];
	static Queue<Integer> que;
	
	static void BFS(int startV, int endV) {
		int nowNode = 0;
		que.add(startV);
		
		while(!que.isEmpty()) {
			nowNode = que.poll();
			
			if(nowNode == endV) break;
			
			if(nowNode + 1 >= 0 && nowNode + 1 < 100100 && count[nowNode + 1]==0) { // 100000 + 100
				que.add(nowNode + 1);
				count[nowNode + 1] = count[nowNode] + 1;
			}
			
			if(nowNode-1 >= 0 && nowNode -1 < 100100 && count[nowNode - 1]==0) { // now >= 0 조건 주의!!
				que.add(nowNode - 1);
				count[nowNode - 1] = count[nowNode] + 1;
			}
			
			if(nowNode*2 < 100100 && nowNode * 2 >= 0 && count[nowNode * 2] == 0) {
				que.add(nowNode * 2);
				count[nowNode * 2] = count[nowNode] + 1;
			}
		} // 값을 찾았을 때 while문 종료
		
		System.out.println(count[nowNode]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		 
		System.out.println(N + ", " + K);
		que = new ArrayDeque<>();	
		BFS(N, K);
	}
}
