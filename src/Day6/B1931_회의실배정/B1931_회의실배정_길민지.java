package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_길민지 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int arr[][] = new int [N][2];
		int result[] = new int[N];
		
		// 회의 시간 입력
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<N; i++) result[i] = -1;
		
		// 정렬
		Arrays.sort(arr, (a1, a2)->{
			if(a1[1]==a2[1]) return Integer.compare(a1[0], a2[0]); // 종료 시간이 같다면 시작 시간 오름차순으로 정렬
			else return Integer.compare(a1[1], a2[1]); // 종료 시간 오름차순으로 정렬
		});
		Arrays.sort(arr, (a1, a2)-> a1[1]==a2[1]?a1[0]-a2[0]:a1[1]-a2[1]);
		int end = arr[0][1]; 
		int cnt = 1;
		
		for (int i = 1; i<N; i++) {
			if (arr[i][0]>=end) { // 회의 종료 시간보다 시작 시간이 같거나 늦다면
				cnt++; // 회의 가능
				end = arr[i][1]; // 회의 종료 시간 변경
			}
		}
		// 정답 출력
		System.out.println(cnt);
	}
}
