package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int timeTable[][] = new int[N][2];
		for (int n = 0; n < N; n++) {
			StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
			
			timeTable[n][0] = Integer.parseInt(token.nextToken());
			timeTable[n][1] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(timeTable, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // 회의 끝나는 시간이 빠른 시간을 기준으로 정렬  // 회의 끝나는 시간이 같다면, 회의 시작 시간이 빠른 시간을 기준으로 정렬
		
		int start = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if (start <= timeTable[i][0]) {
				count++;
				
				start = timeTable[i][1];
			}
		}
		
		System.out.println(count);
	}
}
