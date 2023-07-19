package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_강윤서 {
	static int[] graph;
	static int n; // 수빈 위치
	static int k; // 동생 위치
	static Queue <Integer> queue = new ArrayDeque<>();
	
	public static void bfs(int startNode) { // 너비 우선 탐색-큐
		graph[startNode]=1; // 시작 위치
		queue.offer(startNode); // 시작 노드 방문
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			if (nowNode==k) // 동생 위치로 도달
				break;
			
			// 걷기 +1
			int nextNode = nowNode+1;
			if (nextNode<=100000 && graph[nextNode]==0) { // 위치 범위 내이고, 아직 방문 처리 안했으면
				queue.add(nextNode);
				graph[nextNode] = graph[nowNode]+1; // 현재 이동 시간으로 업데이트
			}
			
			// 걷기 -1
			nextNode = nowNode-1;
			if (nextNode>=0 && graph[nextNode]==0) { // 위치 범위 내이고, 아직 방문 처리 안했으면
				queue.add(nextNode);
				graph[nextNode] = graph[nowNode]+1; // 현재 이동 시간으로 업데이트
			}
			
			// 순간이동 *2
			nextNode = nowNode*2;
			if (nextNode<=100000 && graph[nextNode]==0) { // 위치 범위 내이고, 아직 방문 처리 안했으면
				queue.add(nextNode);
				graph[nextNode] = graph[nowNode]+1; // 현재 이동 시간으로 업데이트
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 수빈 위치
		k = Integer.parseInt(st.nextToken()); // 동생 위치
		
		graph = new int[100001]; // 0~10000
		
		// BFS 수행
		bfs(n);
		System.out.println(graph[k]-1);
	}
}
