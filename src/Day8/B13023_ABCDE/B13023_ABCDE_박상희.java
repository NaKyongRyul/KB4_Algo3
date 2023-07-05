package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_박상희 {
	static int N; // 사람의 수
	static ArrayList<Integer> people[];
	static boolean isVisited[];
	static boolean flag = false;
	
	public static void findFriends(int startNode, int cnt) {
		if (cnt >= 4) {
			flag = true;
			return;
		}
		
		isVisited[startNode] = true;
		for (int nextNode : people[startNode]) {
			if (!isVisited[nextNode]) {
				isVisited[nextNode] = true;
				findFriends(nextNode, cnt + 1);
				isVisited[nextNode] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken()); // 사람의 수(5 <= N <= 2000)
		int M = Integer.parseInt(token.nextToken()); // 친구 관계의 수(1 <= M <= 2000)
		
		people = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			people[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int me = Integer.parseInt(token.nextToken());
			int friend = Integer.parseInt(token.nextToken());
			
			people[me].add(friend);
			people[friend].add(me);
		}

		for (int n = 0; n < N; n++) {
			isVisited = new boolean[N];
			
			findFriends(n, 0);
			
			if (flag) {
				System.out.println(1);
				break;
			}
		}
		
		if (!flag) {
			System.out.println(0);
		}
	}
}
