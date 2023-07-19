package Day8.B2178_미로탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_김현지 {

	static int N;
	static int M;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	
//	static ArrayList <Integer>[] graph;
	static int [][] graph;
	static int [][] visited;
	

	// bfs가 레벨별로 탐색을 진행하기 때문에 더 적합하다고 판단
	// dfs로 모든 경로 탐색 후 최솟값을 구하는 것보다 효율적
	public static void bfs(int x, int y) {
		// 큐 초기화, 원소를 두개 추가할 땐 arraydeque아닌 linked list 사용
		// & Point 객체 import 해오자
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
//		visited[x][y] = level;
		while (!que.isEmpty()) {
			Point p = que.poll();
//			System.out.println("방문한 x: " + p.x + ", y: " + p.y + ", level: " + level);
			// 이 시점에서 답을 뽑아주려면 main함수에 로직 구현해서 return 
			if (p.x == N-1 && p.y == M-1) {
//				System.out.println("(N,M)에 도달");
				return;
			}
			
			int nx; int ny; 
			for (int i=0; i< 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				// 범위 벗어나면 삭제
				if (nx <= -1 || nx >= N || ny <= -1 || ny >= M) {
					continue;
				}
				if (graph[nx][ny] == 1 && visited[nx][ny] == 0) {
//					System.out.println("que 더해짐: " + nx + " " + ny);
					que.add(new Point(nx,ny));
					// 이 부분 놓침
					visited[nx][ny] = visited[p.x][p.y] + 1;
//					System.out.println("que:" + que);
					
				} 
			}
		}
	}

	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 그래프 초기화
//		graph = new ArrayList [N];
		graph = new int [N][M];
		visited = new int [N][M];

//		for (int i=0; i<N; i++) {
//			graph[i] = new ArrayList<Integer>();
//		}
		
	    // 간선 연결
		int node;
	    for (int i=0; i<N; i++) {
	    	String str = br.readLine();
	    	String [] strs = str.split("");
	    	for (int j=0; j<M; j++) {
		    	node = Integer.parseInt(strs[j]);
		    	graph[i][j] = node;
//		    	graph[i].add(node);
	    	}
	    }
	    
//		// graph에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(graph[i]);
//		}
//	    System.out.println(Arrays.deepToString(graph));
	    



	    visited[0][0] = 1;
	    bfs(0,0);
	    System.out.println(visited[N-1][M-1]);
//	    System.out.println(Arrays.deepToString(visited));

	}

}
