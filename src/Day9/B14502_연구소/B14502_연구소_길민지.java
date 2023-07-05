package Day9.B14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소_길민지 {
	static int N, M;
	static int map[][];
	static int temp[][];
	static int di[] = {0,0,1,-1};
	static int dj[] = {1,-1,0,0};
	static int cnt, cntMax;
	static int c;
	
	// 범위 검사
	static boolean checkValid(int i, int j) {
		if (i<0 || i>=N || j<0 || j>=M) return false;
		return true;
	}
	
	// 벽 만들기 (백트래킹)
	static void makeWall(int cntWall) {
		if (cntWall == 3) {
			countSafeZone();
			return;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cntWall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 안전지대 카운트
	static void countSafeZone() {
		// 맵 초기화
		for (int i=0; i<N; i++) temp[i] = map[i].clone();
		cnt = 0;
		
		// 바이러스 전파
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 2) virus(i,j,temp);
			}
		}
		
		// 안전지대 세기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (temp[i][j] == 0) cnt ++;
			}
		}
		
		// 안전지대 최댓값 갱신
		cntMax = (cntMax>cnt)?cntMax:cnt;
	}
	
	// 바이러스 전파
	static void virus(int i, int j, int [][] tmp) {
		tmp[i][j] = 2;
		for (int k=0; k<4; k++) {
			int next_i = i + di[k];
			int next_j = j + dj[k];
			
			if (!checkValid(next_i, next_j) || tmp[next_i][next_j] != 0) continue;
			
			virus(next_i, next_j, tmp);
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 지도 입력
		map = new int [N][M];
		temp = new int [N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 바이러스 발생
		makeWall(0);
		
		System.out.println(cntMax);
	}

}

