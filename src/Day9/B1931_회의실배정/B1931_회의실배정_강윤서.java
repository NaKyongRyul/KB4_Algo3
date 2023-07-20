package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		// 회의 정보
		int[][] meeting = new int[n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 회의 종료 시간이 빠른 순으로 정렬
		Arrays.sort(meeting, (a, b)->(a[1]!=b[1]?a[1]-b[1]:a[0]-b[0])); // 종료시간 짧은 것, 시작시간 짧은 것 오름차순 정렬
		
		int curTime = 0; // 현재 시간
		int count = 0;
		
		// 최대 회의 개수 계산
		for (int i=0; i<n; i++) {
			if (meeting[i][0]>=curTime) { // 다음 회의 시작 시간>=현재 회의 종료 시간->회의 가능
				curTime = meeting[i][1]; // 다음 회의 종료 시간으로 현재 시간 업데이트
				count++;
			}
		}
		System.out.println(count);
	}
}
