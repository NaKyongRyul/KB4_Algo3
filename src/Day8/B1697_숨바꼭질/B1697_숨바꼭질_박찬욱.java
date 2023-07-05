package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_박찬욱 {
	
	static int N; // 수빈의 자리 (0 ≤ N ≤ 100,000)
	static int K; // 동생의 자리 (0 ≤ K ≤ 100,000)
	static int [] arr; // 이동한 거리와 시간을 기록하기 위한 배열
	
	
	// 최소값 찾기 =  BFS
	public static void BFS(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		arr[start] = 1;
		
		while (!que.isEmpty()) {
			int nowN = que.poll(); // 현재 수빈이의 자리
			for(int i = 0; i < 3; i++) {
				int nextN; // 이동 후, 수빈의 위치
				if (i == 2) nextN = nowN * 2; // 이동 케이스, 현재 자리에서 *2
				else if (i == 1) nextN = nowN + 1; // 이동 케이스, 현재 자리에서 +1
				else nextN = nowN - 1; // 이동 케이스, 현재 자리에서 -1
				
				if(nextN == K) { // 이동한 자리에 동생이 있는 경우
					System.out.println(arr[nowN]);
					return;
				}
				// nextN >= 0 && nextN < arr.length : 이동한 자리 = 정상적인 자리, arr[nextN] == 0 : 이동이 반복되지 않기 위한 장치
				if(nextN >= 0 && nextN < arr.length && arr[nextN] == 0){ 
					que.add(nextN); // 이동한자리에서 이동을 위한 que에 값 추가
					arr[nextN] = arr[nowN] + 1; // 이동한 자리에 시간을 1초 추가
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		arr = new int [100_001];
		
		if(N == K) System.out.println(0); // 수빈과 동생의 자리가 같은 경우에는 이동할 필요X
		else BFS(N); // 그외에는 이동한다.
		
	}
}