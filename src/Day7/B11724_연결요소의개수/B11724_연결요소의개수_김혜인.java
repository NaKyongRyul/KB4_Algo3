package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연결리스트 그려보면 방문횟수랑 연결 요소개수랑 동일 > dfs가 간단할 것 같아서 구현
public class B11724_연결요소의개수_김혜인{
	
	
	static int[][] arr;
	static boolean[] isvisited;  // 
	static int count = 0; // 방문횟수 세기
	static int N, M; // 접점수, 간선수
	
	
	public static void dfs(int v) {	
		//들어오면 본인 방문 설정
		isvisited[v] = true;
		//재귀 
		for (int i = 1; i <= N; i++) {
			if(arr[v][i] == 1 && !isvisited[i]) dfs(i); // 서로 인접 + 방문 안했을 때 출력
			}
		}	
		
		
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	     N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken()); 
	     
	     arr = new int [1001][1001];   //좌표 그대로 받아드림
	     isvisited = new boolean[1001]; //우선 초기값 false로 설정 > 탐색 후 연결 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			//초기값 1로 설정해줌 
			arr[node1][node2] = 1;
			arr[node2][node1] = 1;
		}
		
		int count = 0;
		for(int a = 1; a<N+1; a++) {
			if(!isvisited[a]) {
				dfs(a);
				count++;
			}
		}
		
		System.out.println(count);
		}
	
	
}


	
 
			
	
 