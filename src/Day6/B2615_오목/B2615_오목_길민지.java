package Day6.B2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615_오목_길민지 {
	static int[][] arr;
	static int winner;
	static int start_i, start_j;
	static int dy[] = {0, 1, -1, 1};
	static int dx[] = {1, 0, 1, 1};
	
	static void find(int color, int i, int j, int dir, int cnt) {
		if (i>19||j>19||i<1||j<1) { // 바둑판 밖으로 넘어가면 종료
			if (cnt==5) { // 오목인 경우
				winner = color;
			}
			return;
		}
		if (cnt>5) { // 5개 이상 이어지면 종료
			return;
		}
		else if (arr[i][j]!=color) { // 기준점 색과 다르면 종료
			if (cnt==5) { // 오목인 경우
				winner = color;
			}
			return;
		}
		
		
		// 같은 색이라면
		cnt++;
		for (int d=0; d<4; d++) {
			find(color,i + dy[d], j+dx[d], dir, cnt);
		}
		
		if (winner!=0) { // 우승자가 정해졌다면
			start_i = i;
			start_j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[20][20];
		// 배열 입력
		for (int i=1; i<20; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j=1;j<20; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				int color = arr[i][j];
				if (winner==0 && color!=0) {
					if (arr[i][j-1]!=color) find(color, i, j, 0, 0);
					if (arr[i-1][j]!=color)find(color, i, j, 1, 0);
					if (((i!=19)?arr[i+1][j-1]:0)!=color)find(color, i, j, 2, 0);
					if (arr[i-1][j-1]!=color)find(color, i, j, 3, 0);
				}
			}
		}
		
		// 출력
		System.out.println(winner);
		if (winner!=0) System.out.println(start_i+" "+start_j);
	}

}
