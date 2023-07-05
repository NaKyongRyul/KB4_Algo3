package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_박상희 {
	static int N;
	static ArrayList<Integer> computer[];
	static boolean isVisited[];
	static int cnt;
	static int count[];
	
	public static int searchComputer(int startNode) {		
		Queue <Integer> que = new LinkedList<>();
		que.add(startNode);
		isVisited[startNode] = true;
		
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			cnt++;
			for(int nextNode : computer[nowNode]) {
				if(isVisited[nextNode] == true) {
					continue;
				}
				
				que.add(nextNode);
				isVisited[nextNode] = true;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		computer = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			computer[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine(), " ");
			
			int believer = Integer.parseInt(token.nextToken());
			int truster = Integer.parseInt(token.nextToken());
			
			computer[truster].add(believer);
		}

		count = new int[N + 1];
		int max = 0;
		for (int n = 1; n < N + 1; n++) {
			cnt = 0;
			isVisited = new boolean[N + 1];
			count[n] = searchComputer(n);
			max = Math.max(max, count[n]);
		}
		
		for (int r = 1; r < N + 1; r++) {
			if (count[r] == max) {
				System.out.print(r + " ");
			}
		}
	}
}
